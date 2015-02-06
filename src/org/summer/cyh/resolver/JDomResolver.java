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
 * ����JDom�ķ�ʽ����
 * @author ChenYh
 *
 */
public class JDomResolver extends AbstractResolver {

	private Handler handler= new XmlHandler();		//�����ڵ�Ĳ���������
	
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
		JudgeTools.NotAllowedNull(doc, "�ĵ�����Ϊ��.......");
		return doc.getRootElement();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Map<Boolean, List<Element>> locationNode(Element root, String requireNodeName) {
		
		Map<Boolean, List<Element>> map = new HashMap<Boolean, List<Element>>();//װһ���ڵ������
		List<Element> hasChildren = new ArrayList<Element>();					//�к��ӽڵ�
		List<Element> notHasChildren = new ArrayList<Element>();				//û�к��ӽڵ�
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
		Map<String, List<ChildBeanDefine>> totalMap = new HashMap<String, List<ChildBeanDefine>>(); //װ���е��ӽڵ��Map
		
		for (Element element : parentNode) {
			totalMap.putAll(handler.handleChildParam(element));
		}
		return totalMap;
	}

	/**
	 * ��Ele����Ľ���������װ
	 * @param nodeList ��Ҫ�����Ľڵ�
	 * hashChild �Ƿ��к��ӽڵ�
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
	 * �ж�һ���ڵ��Ƿ��к����ӽڵ�
	 * @param ele һ���ڵ����
	 * @return false �����У�true:����
	 */
	private boolean hasChild(Element ele){
		return ele.getChildren().size()==0?false:true;
	}
	
	
	/**
	 * ?????????????????????????????�����ӽڵ������____________________=+++++++++++++++++++++
	 */
	
}
