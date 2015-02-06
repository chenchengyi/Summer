package org.summer.cyh.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.InstanceAlreadyExistsException;

import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.resource.Resource;
import org.summer.cyh.util.JudgeTools;
import org.summer.cyh.util.StringUtil;

/**
 * ����θ������Ŀ���  ����λbean ������������ע��
 * @author ChenYh
 *
 */
public abstract class AbsractSingtonBeanFactory extends AbstractBeanFactory{
	
	private boolean isSingleton = false;					 									//�Ƿ��ǵ���
	private Map<String, Object> singtonCachMap = new ConcurrentHashMap<String, Object>();		//�����Ļ�������
	private Map<String, Class<?>> cachMap = new ConcurrentHashMap<String, Class<?>>();			//��Ļ�������
	
	
	public AbsractSingtonBeanFactory(Resource resource) {
		super(resource);
	}

	/**
	 * ���ص������� 
	 * @param name ��������
	 * @return ʵ������
	 * @throws NotFoundException 
	 */
	protected Object getSingtonBean(String singletonName) throws NotFoundException {
		JudgeTools.NotAllowedNull(singletonName, "����Ķ���������Ϊ��......");
		Object obj = singtonCachMap.get(singletonName);
		if(null == obj){
			throw new NotFoundException("����ĵ������󲻴���,���ʼ��......");
		}else{
			return obj;
		}
	}

	/**
	 * ��Ϊbean����������CachMap����
	 * @param name
	 * @param obj
	 * @throws InstanceAlreadyExistsException ʵ���Ѿ�����
	 */
	protected synchronized void setCachMap(String singletonName,Class<?> clazz) throws InstanceAlreadyExistsException {
		
		JudgeTools.NotAllowedNullParam(new Object[]{singletonName , clazz},"����bean�����ֻ�ʵ������Ϊ��......");
		if(cachMap.containsKey(singletonName) || cachMap.get(singletonName)==clazz){
			throw new InstanceAlreadyExistsException("ʵ���Ѿ�����......");
		}else{
			cachMap.put(singletonName, clazz);
		}
	}
	
	
	/**
	 * �ж��Ƿ��ǵ���
	 * @return
	 */
	public boolean isSingleton(String beanDefine) {
		return getBeanMap().get(beanDefine).isSingleton();
	}

	
	/**
	 * ���õ���
	 * @param isSingleton
	 */
	public void setSingleton(boolean isSingleton) {
		this.isSingleton = isSingleton;
	}

	@Override
	public Object getBean(String name) {
		
		setSingleton(isSingleton(name));
		
		Object beanObj = injectProperty(name);    //�õ�ע�������Ե�bean
		
		if(isSingleton){
			if(singtonCachMap.get(name)==null){
					singtonCachMap.put(name, beanObj);
			}
			
			return singtonCachMap.get(name);
		}else{
			return beanObj;
		}
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) {
		
		/**
		 * ......��ûд.......
		 * 
		 */
		
		return super.getBean(name, requiredType);
	}

	@Override
	public <T> T getBean(Class<T> requiredType) {
		/**
		 * ......��ûд.......
		 * 
		 */
		return super.getBean(requiredType);
	}

	@Override
	protected Object injectProperty(String beanName) {
		Class<?> beanClazz = null;											   //bean�����class����
		Object beanObj = null;												   //bean�������ע�������ʵ��
		List<ChildBeanDefine> childList = getSecondNodeMap().get(beanName);    //�õ���Ҫע��Ľڵ�(property)
		
		
		try {
			
			beanClazz = Class.forName(getBeanMap().get(beanName).getClazz());
			beanObj = beanClazz.newInstance();
		
			for (ChildBeanDefine childBeanDefine : childList) {
				String childName = childBeanDefine.getBeanDefineName();
				String refId = childBeanDefine.getRefId();
				
				Class<?> propertyClazz = Class.forName(getBeanMap().get(refId).getClazz());
				
				
				Method method = beanClazz.getMethod(StringUtil.toUpCaseAndaddSet(childName),
						new Class[]{propertyClazz});
				
				method.invoke(beanObj ,new Object[]{propertyClazz.newInstance()});
			
			}
		
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return beanObj;
	}
}
