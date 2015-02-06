package org.summer.cyh.bean;

import org.jdom.Element;
import org.summer.cyh.util.JudgeTools;

/**
 * �ӽڵ��beanDefine ,������:���õ��������ĸ��ڵ�
 * @author ChenYh
 *
 */
public class ChildBeanDefine implements SecondBeanDefine{

	private String name="";			//����
	private String refId ="";		//��ص�bean��id
	private String parentId = ""; 	//���ڵ��Id
	private Element ele;			//��BeanDefine�Ľڵ����
			
	public ChildBeanDefine() {
		super();
	}
	
	public ChildBeanDefine(String name, String refId) {
		JudgeTools.NotAllowedNullParam(new String[]{name ,refId}, "bean�ĺ��ӽڵ�Ĳ�������Ϊ��......");
		this.name = name;
		this.refId = refId;
		
	}

	@Override
	public String getBeanDefineName() {
		return name;
	}

	public void setName(String name) {
		JudgeTools.NotAllowedNull(name, "bean�ĺ��ӽڵ�����ֲ���Ϊ��......");
		this.name = name;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		JudgeTools.NotAllowedNull(refId, "bean�ĺ��ӽڵ�����id(ref)����Ϊ��......");
		this.refId = refId;
	}
	
	@Override
	public String getParentId() {
		return parentId;
	}
	
	@Override
	public void setParentId(String parentId) {
		JudgeTools.NotAllowedNull(parentId, "bean�ĺ��ӽڵ�ĸ��ڵ��Id����Ϊ��......");
		this.parentId = parentId;
	}

	@Override
	public void setNode(Element ele) {
		JudgeTools.NotAllowedNull(ele, "ChildBeanDefine�Ľڵ㲻��Ϊ��......");
		this.ele = ele;
	}

	@Override
	public Element getNode() {
		return ele;
	}
	
}
