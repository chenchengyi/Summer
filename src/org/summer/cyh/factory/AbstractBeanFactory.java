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
 * 抽象工厂类(从这里可以扩展出Anotation的形式)
 * 这一层次负责将BeanDefine注入到IOC容器中,并初始化一些处理器及资源的参数
 * @author ChenYh
 *
 */
public abstract class AbstractBeanFactory implements BeanFactory{

	/**
	 * 用来装bean的容器
	 */
	private static Map<String, FirstBeanDefine> firstNodeMap = new ConcurrentHashMap<String, FirstBeanDefine>();
	private static Map<String, List<ChildBeanDefine>> secondNodeMap = new ConcurrentHashMap<String, List<ChildBeanDefine>>();
	private Resource resource;											//资源器创建
	private Resolver resolver;
	
	
	public AbstractBeanFactory(Resource resource) {
		JudgeTools.NotAllowedNull(resource, "资源必须初始化......");
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
	 * 得到当前的Map
	 * @return
	 */
	public Map<String, FirstBeanDefine> getBeanMap(){
		return firstNodeMap;
	}

	/**
	 * 给map赋值
	 * @param map 传入一个Map
	 * @throws NullException 
	 */
	protected void setBeanMap(Map<String, FirstBeanDefine> map){
		JudgeTools.NotAllowedNull(map, "");
		firstNodeMap.putAll(map);
		
	}
	/**
	 * 单个元素注入Map
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
	 * 设置资源处理器
	 * @param resolver
	 */
	protected void setResolver(Resolver resolver){
		this.resolver = resolver;
	}
	
	/**
	 * 返回解析器对象
	 * @return:处理器：这里注入了处理器（可以使用不同的解析方法如：注解性的，XMl型的，使用了策略模式）
	 */
	protected Resolver getResolver() {
		return resolver;
	}
	
	/**
	 * 返回资源对象
	 * @return
	 */
	public Resource getResouce() {
		return resource;
	}
	
	/**
	 * 实例化资源对象
	 * @param resouce
	 * @throws InstanceAlreadyExistsException 
	 */
	public void setResouce(Resource resource) throws InstanceAlreadyExistsException {
		JudgeTools.NotAllowedNull(resource, "资源对象不能为空......");
		if(null == resource){
			this.resource = resource;
		}else{
			throw new InstanceAlreadyExistsException("资源对象实例已经存在......");
		}
	}

	/**
	 * 注册 不管是哪种方式注册，，实现的方式都是一样的,所有设为抽象的
	 * @param firstBeanMap 
	 */
	protected abstract void registe();
	
	/**
	 * 定位节点
	 * @return
	 */
	protected Map<Boolean, List<Element>> locationBean(){return null;}
	
	/**
	 * 解析节点的参数
	 * @param ele 需要解析的节点
	 * @return
	 */
	protected Map<String, FirstBeanDefine> parseNode(){return null;}

	/**
	 * 解析二级节点 并将其注入到二级节点的容器
	 * @param parentNode
	 * @return
	 */
	protected void parseAndParseSecondNode(){};
	
	
	/**
	 * 注入属性对象,需要用到该方法可以将其覆盖.
	 * @return 返回注入了属性的bean对象的实例
	 */
	protected Object injectProperty(String beanName) {return null;}
	
}
