package org.summer.cyh.bean;

/**
 * ���ڰ�װ bean�� �ӿ�
 * @author Administrator
 *
 */
public interface FirstBeanDefine extends BaseBeanDefine{
	
	/**
	 * �����Ƿ��ӳټ���
	 * @param isLazyInit
	 */
	void setLazyInit(boolean isLazyInit);
	
	/**
	 * �����Ƿ��ӳټ���
	 * @return
	 */
	boolean isLazyInit();
	
	
	/**
	 * �����Ƿ��ǵ���
	 * @param SingleTon
	 */
	void setSingleton(boolean isSingleton);
	
	/**
	 * �����Ƿ��ǵ��� 
	 * @return �Ƿ��ǵ���
	 */
	boolean isSingleton();
	
	/**
	 * ���ýڵ��ע��ڵ�(����)
	 * @param beanId �ڵ��Id ��ref
	 */
	void setChild(String beanId);
	
	/**
	 * ���ýڵ��ע��ڵ�(���)
	 * @param beanIds �ڵ��Id ��ref
	 */
	void setChildren(String[] beanIds);
	
	/**
	 * ���ظýڵ�����е�ע��(property)�Ľڵ�
	 * @return
	 */
	String[] getChildren();
	
	
	/**
	 * ����bean��class�����ֵ
	 * @param clazz
	 */
	void setClazz(String clazz);
	
	
	String getClazz();
	
}
