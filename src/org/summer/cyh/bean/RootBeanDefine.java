package org.summer.cyh.bean;

import org.jdom.Element;
import org.summer.cyh.util.JudgeTools;

/**
 * ���ڵ��BeanDefine
 * @author ChenYh
 *
 */
public class RootBeanDefine extends AbstractBeanDefine{
	private Element ele;			//��BeanDefine�Ľڵ����
	
	public RootBeanDefine(String beanDefineName) {
		super(beanDefineName);
	}
	
	public static void main(String[] args) {
	}

	//�����ֻ�����XML�Ľڵ���Ч��
	@Override
	public void setNode(Element ele) {
		JudgeTools.NotAllowedNull(ele, "RootBeanDefine�Ľڵ㲻��Ϊ��......");
		this.ele = ele;
	}

	@Override
	public Element getNode() {
		return ele;
	}

}
