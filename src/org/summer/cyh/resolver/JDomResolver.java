package org.summer.cyh.resolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.bean.FirstBeanDefine;
import org.summer.cyh.exception.NotBeAllowedOPerate;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;
import org.summer.cyh.pools.ParseTools;
import org.summer.cyh.resolver.handler.Handler;
import org.summer.cyh.resolver.handler.XmlHandler;
import org.summer.cyh.resource.Resource;
import org.summer.cyh.util.JudgeTools;

/**
 * 采用JDom的方式解析
 * @author ChenYh
 *
 */
public class JDomResolver extends AbstractResolver {

	private Handler handler= new XmlHandler();		//创建节点的参数处理器
	
	public JDomResolver(Resource resouce) throws NullParamException, NotMach, NotFoundException, NotBeAllowedOPerate {
		super(resouce);
	}

	@Override
	protected Document getDocument() {
		try {
			return ParseTools.createParseTool(SAXBuilder.class).build(getFile());
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected Element getRootElement(Document doc) {
		JudgeTools.NotAllowedNull(doc, "文档对象为空.......");
		return doc.getRootElement();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Map<Boolean, List<Element>> locationNode(Element root, String requireNodeName) {
		
		Map<Boolean, List<Element>> map = new HashMap<Boolean, List<Element>>();//装一级节点的容器
		List<Element> hasChildren = new ArrayList<Element>();					//有孩子节点
		List<Element> notHasChildren = new ArrayList<Element>();				//没有孩子节点
		List<Element> list = root.getChildren(requireNodeName);
		
		for (Element element : list) {
			if(hasChild(element)){
				hasChildren.add(element);
			}else{
				notHasChildren.add(element);
			}
		}
		map.put(true, hasChildren);
		map.put(false, notHasChildren);
		return map;
	}

	
	@Override
	protected Map<String, FirstBeanDefine> parseFirstNodeParam(Map<Boolean, List<Element>> node) {
		Map<String, FirstBeanDefine> map = new HashMap<String, FirstBeanDefine>();
		map.putAll(getBeanDefineMap(node.get(true), true));
		map.putAll(getBeanDefineMap(node.get(false), false));
		return map;
	}
	
	
	
	@Override
	protected Map<String, List<ChildBeanDefine>> parseSecondNodeParam(
			List<Element> parentNode) {
		Map<String, List<ChildBeanDefine>> totalMap = new HashMap<String, List<ChildBeanDefine>>(); //装所有的子节点的Map
		
		for (Element element : parentNode) {
			totalMap.putAll(handler.handleChildParam(element));
		}
		return totalMap;
	}

	/**
	 * 将Ele里面的解析出来封装
	 * @param nodeList 需要解析的节点
	 * hashChild 是否有孩子节点
	 * @return
	 */
	private Map<String, FirstBeanDefine> getBeanDefineMap(List<Element> nodeList,boolean hashChild){
		Map<String, FirstBeanDefine> map = new HashMap<String, FirstBeanDefine>();
		for (Element element : nodeList) {
			FirstBeanDefine beanDefien = handler.handleBeanParam(element, hashChild);
			map.put(beanDefien.getBeanDefineName() , beanDefien);
		}
		return map;
	}

	
	/**
	 * 判断一个节点是否有孩子子节点
	 * @param ele 一个节点对象
	 * @return false 不含有，true:含有
	 */
	private boolean hasChild(Element ele){
		return ele.getChildren().size()==0?false:true;
	}
	
	
	/**
	 * ?????????????????????????????处理子节点的容器____________________=+++++++++++++++++++++
	 */
	
}
