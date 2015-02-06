package org.summer.cyh.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.InstanceAlreadyExistsException;

import org.jdom.Element;
import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.bean.FirstBeanDefine;
import org.summer.cyh.resolver.Resolver;
import org.summer.cyh.resource.Resource;
import org.summer.cyh.util.JudgeTools;

/**
 * ���󹤳���(�����������չ��Anotation����ʽ)
 * ��һ��θ���BeanDefineע�뵽IOC������,����ʼ��һЩ����������Դ�Ĳ���
 * @author ChenYh
 *
 */
public abstract class AbstractBeanFactory implements BeanFactory{

	/**
	 * ����װbean������
	 */
	private static Map<String, FirstBeanDefine> firstNodeMap = new ConcurrentHashMap<String, FirstBeanDefine>();
	private static Map<String, List<ChildBeanDefine>> secondNodeMap = new ConcurrentHashMap<String, List<ChildBeanDefine>>();
	private Resource resource;											//��Դ������
	private Resolver resolver;
	
	
	public AbstractBeanFactory(Resource resource) {
		JudgeTools.NotAllowedNull(resource, "��Դ�����ʼ��......");
		this.resource = resource;
	}

	@Override
	public Object getBean(String name) {
		return firstNodeMap.get(name);
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) {
		return null;
	}

	@Override
	public <T> T getBean(Class<T> requiredType) {
		return null;
	}

	@Override
	public boolean isExist(String name) {
		return firstNodeMap.containsKey(name);
	}
	
	/**
	 * �õ���ǰ��Map
	 * @return
	 */
	public Map<String, FirstBeanDefine> getBeanMap(){
		return firstNodeMap;
	}

	/**
	 * ��map��ֵ
	 * @param map ����һ��Map
	 * @throws NullException 
	 */
	protected void setBeanMap(Map<String, FirstBeanDefine> map){
		JudgeTools.NotAllowedNull(map, "");
		firstNodeMap.putAll(map);
		
	}
	/**
	 * ����Ԫ��ע��Map
	 * @param name
	 * @param bean
	 * @throws InstanceAlreadyExistsException 
	 */
	protected void setBeanMap(String name , FirstBeanDefine bean){
		JudgeTools.NotAllowedNullParam(new Object[]{name , bean}, "");
		if(firstNodeMap.containsKey(name)){
			try {
				throw new InstanceAlreadyExistsException();
			} catch (InstanceAlreadyExistsException e) {
				e.printStackTrace();
			}
		}else{
			Map<String, FirstBeanDefine> map = new HashMap<String, FirstBeanDefine>();
			map.put(name, bean);
			setBeanMap(map);
		}
	}
	
	
	
	
	public static Map<String, List<ChildBeanDefine>> getSecondNodeMap() {
		return secondNodeMap;
	}

	public static void setSecondNodeMap(Map<String, List<ChildBeanDefine>> secondMap) {
		JudgeTools.NotAllowedNull(secondMap, "");
		secondNodeMap.putAll(secondMap);
	}

	/**
	 * ������Դ������
	 * @param resolver
	 */
	protected void setResolver(Resolver resolver){
		this.resolver = resolver;
	}
	
	/**
	 * ���ؽ���������
	 * @return:������������ע���˴�����������ʹ�ò�ͬ�Ľ��������磺ע���Եģ�XMl�͵ģ�ʹ���˲���ģʽ��
	 */
	protected Resolver getResolver() {
		return resolver;
	}
	
	/**
	 * ������Դ����
	 * @return
	 */
	public Resource getResouce() {
		return resource;
	}
	
	/**
	 * ʵ������Դ����
	 * @param resouce
	 * @throws InstanceAlreadyExistsException 
	 */
	public void setResouce(Resource resource) throws InstanceAlreadyExistsException {
		JudgeTools.NotAllowedNull(resource, "��Դ������Ϊ��......");
		if(null == resource){
			this.resource = resource;
		}else{
			throw new InstanceAlreadyExistsException("��Դ����ʵ���Ѿ�����......");
		}
	}

	/**
	 * ע�� ���������ַ�ʽע�ᣬ��ʵ�ֵķ�ʽ����һ����,������Ϊ�����
	 * @param firstBeanMap 
	 */
	protected abstract void registe();
	
	/**
	 * ��λ�ڵ�
	 * @return
	 */
	protected Map<Boolean, List<Element>> locationBean(){return null;}
	
	/**
	 * �����ڵ�Ĳ���
	 * @param ele ��Ҫ�����Ľڵ�
	 * @return
	 */
	protected Map<String, FirstBeanDefine> parseNode(){return null;}

	/**
	 * ���������ڵ� ������ע�뵽�����ڵ������
	 * @param parentNode
	 * @return
	 */
	protected void parseAndParseSecondNode(){};
	
	
	/**
	 * ע�����Զ���,��Ҫ�õ��÷������Խ��串��.
	 * @return ����ע�������Ե�bean�����ʵ��
	 */
	protected Object injectProperty(String beanName) {return null;}
	
}
