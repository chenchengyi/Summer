package org.summer.cyh.bean;

import org.jdom.Element;

/**
 * 基础的BeanDefine
 * @author ChenYuh
 *
 */
public interface BaseBeanDefine {

	/**
	 * 返回BeanDefine的名字
	 * RootBeanDefine 的id属性
	 * ChildBeanDefien 的name属性
	 * @return 返回
	 */
	String getBeanDefineName();
	
	/**
	 * 将该节点封装在BaseBeanDefine中
	 * @param ele 节点
	 */
	void setNode(Element ele);
	
	/**
	 * 返回该BaseBeanDefine的节点对象
	 * @return
	 */
	Element getNode();
}
