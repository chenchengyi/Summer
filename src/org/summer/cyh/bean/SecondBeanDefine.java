package org.summer.cyh.bean;
/**
 * �����ڵ��BeanDefine�ӿ�
 * @author ChenYuh
 *��������������������������չ
 */
public interface SecondBeanDefine extends BaseBeanDefine{
	
	/**
	 * ���ø��ڵ��Id
	 * @param parentId ���ڵ��Id
	 */
	void setParentId(String parentId);
	
	/**
	 * �õ����ڵ��Id
	 * @return ���ڵ��id
	 */
	String getParentId();
	
}
