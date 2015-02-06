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
 * 本层次负责单例的控制  并定位bean 并将解析的类注入
 * @author ChenYh
 *
 */
public abstract class AbsractSingtonBeanFactory extends AbstractBeanFactory{
	
	private boolean isSingleton = false;					 									//是否是单例
	private Map<String, Object> singtonCachMap = new ConcurrentHashMap<String, Object>();		//单例的缓存容器
	private Map<String, Class<?>> cachMap = new ConcurrentHashMap<String, Class<?>>();			//类的缓存容器
	
	
	public AbsractSingtonBeanFactory(Resource resource) {
		super(resource);
	}

	/**
	 * 返回单例对象 
	 * @param name 对象名称
	 * @return 实例对象
	 * @throws NotFoundException 
	 */
	protected Object getSingtonBean(String singletonName) throws NotFoundException {
		JudgeTools.NotAllowedNull(singletonName, "传入的对象名不能为空......");
		Object obj = singtonCachMap.get(singletonName);
		if(null == obj){
			throw new NotFoundException("所需的单例对象不存在,请初始化......");
		}else{
			return obj;
		}
	}

	/**
	 * 将为bean的类对象放在CachMap里面
	 * @param name
	 * @param obj
	 * @throws InstanceAlreadyExistsException 实例已经存在
	 */
	protected synchronized void setCachMap(String singletonName,Class<?> clazz) throws InstanceAlreadyExistsException {
		
		JudgeTools.NotAllowedNullParam(new Object[]{singletonName , clazz},"传入bean的名字或实例不能为空......");
		if(cachMap.containsKey(singletonName) || cachMap.get(singletonName)==clazz){
			throw new InstanceAlreadyExistsException("实例已经存在......");
		}else{
			cachMap.put(singletonName, clazz);
		}
	}
	
	
	/**
	 * 判断是否是单例
	 * @return
	 */
	public boolean isSingleton(String beanDefine) {
		return getBeanMap().get(beanDefine).isSingleton();
	}

	
	/**
	 * 设置单例
	 * @param isSingleton
	 */
	public void setSingleton(boolean isSingleton) {
		this.isSingleton = isSingleton;
	}

	@Override
	public Object getBean(String name) {
		
		setSingleton(isSingleton(name));
		
		Object beanObj = injectProperty(name);    //得到注入了属性的bean
		
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
		 * ......还没写.......
		 * 
		 */
		
		return super.getBean(name, requiredType);
	}

	@Override
	public <T> T getBean(Class<T> requiredType) {
		/**
		 * ......还没写.......
		 * 
		 */
		return super.getBean(requiredType);
	}

	@Override
	protected Object injectProperty(String beanName) {
		Class<?> beanClazz = null;											   //bean对象的class对象
		Object beanObj = null;												   //bean对象进行注入对象后的实例
		List<ChildBeanDefine> childList = getSecondNodeMap().get(beanName);    //得到需要注入的节点(property)
		
		
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
