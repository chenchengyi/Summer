package org.summer.cyh.resolver;

import java.util.List;
import java.util.Map;

import org.jdom.Element;
import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.bean.FirstBeanDefine;

/**
 * 处理数据源的接口
 * @author ChenYh
 *
 */
public interface Resolver {
	
	
	/**
	 * 定位一级节点
	 * @param firstNodeName 一级节点的名字(如：bean)
	 * @return 返回所有的一级节点的对象的Map 有孩子节点的key为true，没有的为false
	 */
	Map<Boolean, List<Element>> focusFirstNode(String firstNodeName);
	
	
	/**
	 * 将BeanDefine封装在一个Map中 
	 * @param list 需要解析的节点
	 * @return 返回装有beanDefine的map
	 */
	Map<String, FirstBeanDefine> parseNode(Map<Boolean, List<Element>> node);
	
	
	/**
	 * 将二级节点的封装成一个Map返回
	 * @param parentNode 一级节点对象
	 * @return 二级节点的Map
	 */
	Map<String, List<ChildBeanDefine>> parseSecondNode(List<Element> parentNode);
	
	
	/**
	 * 返回该类的实例对象
	 * @param clazz
	 * @return
	 */
	Object getInstance(Class<?> clazz);
	
}
