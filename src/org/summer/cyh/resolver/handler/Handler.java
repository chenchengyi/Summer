package org.summer.cyh.resolver.handler;

import java.util.List;
import java.util.Map;

import org.jdom.Element;
import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.bean.FirstBeanDefine;
import org.summer.cyh.bean.SecondBeanDefine;

/**
 * 如果需要以其他方式解析节点的参数，可以扩展这个借口
 * 节点的参数处理器
 * @author ChenYuh
 *
 */
public interface Handler {

	/**
	 * 处理一级节点的参数
	 * @param ele指定的节点
	 * @return
	 */
	FirstBeanDefine handleBeanParam(Element ele,boolean hashChild);
	
	/**
	 * 处理SecondBeanDefine节点的参数
	 * @param ele 孩子节点
	 * @return
	 */
	Map<String,List<ChildBeanDefine>> handleChildParam(Element ele);
	
	/**
	 * 返回指定节点的指定参数
	 * @param ele 
	 * @param paramName
	 * @return
	 */
	String reutrnParam(Element ele,String paramName);

}
