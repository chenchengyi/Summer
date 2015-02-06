package org.summer.cyh.bean;

import org.jdom.Element;
import org.summer.cyh.util.JudgeTools;

/**
 * 子节点的beanDefine ,增加了:设置单个依赖的根节点
 * @author ChenYh
 *
 */
public class ChildBeanDefine implements SecondBeanDefine{

	private String name="";			//名字
	private String refId ="";		//相关的bean的id
	private String parentId = ""; 	//父节点的Id
	private Element ele;			//该BeanDefine的节点对象
			
	public ChildBeanDefine() {
		super();
	}
	
	public ChildBeanDefine(String name, String refId) {
		JudgeTools.NotAllowedNullParam(new String[]{name ,refId}, "bean的孩子节点的参数不能为空......");
		this.name = name;
		this.refId = refId;
		
	}

	@Override
	public String getBeanDefineName() {
		return name;
	}

	public void setName(String name) {
		JudgeTools.NotAllowedNull(name, "bean的孩子节点的名字不能为空......");
		this.name = name;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		JudgeTools.NotAllowedNull(refId, "bean的孩子节点的相关id(ref)不能为空......");
		this.refId = refId;
	}
	
	@Override
	public String getParentId() {
		return parentId;
	}
	
	@Override
	public void setParentId(String parentId) {
		JudgeTools.NotAllowedNull(parentId, "bean的孩子节点的父节点的Id不能为空......");
		this.parentId = parentId;
	}

	@Override
	public void setNode(Element ele) {
		JudgeTools.NotAllowedNull(ele, "ChildBeanDefine的节点不能为空......");
		this.ele = ele;
	}

	@Override
	public Element getNode() {
		return ele;
	}
	
}
