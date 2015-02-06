package org.summer.cyh.bean;

import org.jdom.Element;
import org.summer.cyh.util.JudgeTools;

/**
 * 根节点的BeanDefine
 * @author ChenYh
 *
 */
public class RootBeanDefine extends AbstractBeanDefine{
	private Element ele;			//该BeanDefine的节点对象
	
	public RootBeanDefine(String beanDefineName) {
		super(beanDefineName);
	}
	
	public static void main(String[] args) {
	}

	//这个法只针对于XML的节点有效。
	@Override
	public void setNode(Element ele) {
		JudgeTools.NotAllowedNull(ele, "RootBeanDefine的节点不能为空......");
		this.ele = ele;
	}

	@Override
	public Element getNode() {
		return ele;
	}

}
