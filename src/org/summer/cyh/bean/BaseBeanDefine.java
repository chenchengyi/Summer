package org.summer.cyh.bean;

import org.jdom.Element;

/**
 * ������BeanDefine
 * @author ChenYuh
 *
 */
public interface BaseBeanDefine {

	/**
	 * ����BeanDefine������
	 * RootBeanDefine ��id����
	 * ChildBeanDefien ��name����
	 * @return ����
	 */
	String getBeanDefineName();
	
	/**
	 * ���ýڵ��װ��BaseBeanDefine��
	 * @param ele �ڵ�
	 */
	void setNode(Element ele);
	
	/**
	 * ���ظ�BaseBeanDefine�Ľڵ����
	 * @return
	 */
	Element getNode();
}
