package org.summer.cyh.resolver.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Element;
import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.bean.FirstBeanDefine;
import org.summer.cyh.bean.RootBeanDefine;
import org.summer.cyh.bean.SecondBeanDefine;
import org.summer.cyh.bean.param.FirstNodeParam;
import org.summer.cyh.bean.param.SecondNodeParam;
import org.summer.cyh.util.JudgeTools;
/**
 * XML文件的处理类
 * @author ChenYuh
 *
 */
public class XmlHandler implements Handler{

	
	
	
	@Override
	public FirstBeanDefine handleBeanParam(Element ele ,boolean hashChild) {
		FirstBeanDefine rootBeanDefine = new RootBeanDefine(reutrnParam(ele,FirstNodeParam.BEAN_PROPERTY_ID));
		rootBeanDefine.setClazz(reutrnParam(ele, FirstNodeParam.BEAN_PROPERTY_CLASS));
		rootBeanDefine.setSingleton(new Boolean(reutrnParam(ele, FirstNodeParam.SINGLETON)));
		rootBeanDefine.setLazyInit(new Boolean(reutrnParam(ele, FirstNodeParam.BEAN_PROPERTY_LAZYINIT)));
		rootBeanDefine.setNode(ele);
		if(hashChild){
			rootBeanDefine.setChildren(changeMapToArray(handleChildParam(ele)));
		}
		return rootBeanDefine;
	}

	
	@Override
	public String reutrnParam(Element ele, String paramName) {
		JudgeTools.NotAllowedNullParam(new Object[]{ele,paramName}, "解析的节点和参数名不能为空......");
		return ele.getAttributeValue(paramName)==null?"":ele.getAttributeValue(paramName).toString();
	}

	@Override
	public Map<String,List<ChildBeanDefine>> handleChildParam(Element ele) {
		
		@SuppressWarnings("unchecked")
		List<Element> childList = ele.getChildren();
		Map<String,List<ChildBeanDefine>> childMap = new HashMap<String,List<ChildBeanDefine>>();	//装封装的childBean的容器
		String parentId = reutrnParam(ele, FirstNodeParam.BEAN_PROPERTY_ID);						//父节点的Id
		List<ChildBeanDefine> list = new ArrayList<ChildBeanDefine>();							//装一个父节点的所有子节点
		
		
		
		for (Element element : childList) {
			ChildBeanDefine childBeanDefine = new ChildBeanDefine();
			childBeanDefine.setName(reutrnParam(element, SecondNodeParam.NAME));
			childBeanDefine.setRefId(reutrnParam(element, SecondNodeParam.REF));
			childBeanDefine.setParentId(parentId);
			childBeanDefine.setNode(element);
			
			list.add(childBeanDefine);
		}

		childMap.put(parentId, list);
		
		return childMap;
		
	}

	/**
	 * Map里面的ref取出来装换成String[]
	 * @param map
	 * @return
	 */
	private String[] changeMapToArray(Map<String,List<ChildBeanDefine>> map){
		
		
		Iterator<String> it = map.keySet().iterator();
		int flag = 0;	// 数组的下标
		String[] ref =null;
		while(it.hasNext()){
			List<ChildBeanDefine> list= map.get(it.next());
			ref = new String[list.size()];
			
			for (ChildBeanDefine secondBeanDefine : list) {
//				ChildBeanDefine child =  (ChildBeanDefine) secondBeanDefine;
				ref[flag] = secondBeanDefine.getRefId();
				flag++;
			}
			
		}
		return ref;
	}
}
