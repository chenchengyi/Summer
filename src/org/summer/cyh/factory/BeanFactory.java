package org.summer.cyh.factory;


/**
 * bean�����ӿ�
 * @author ChenYh
 *
 */
public interface BeanFactory {

	/**
	 * �������ֵõ�beanʵ��
	 * @param name
	 * @return
	 */
	Object getBean(String name) ;
	
	
	/**
	 * �������ͺ�bean�������õ���Ӧ��bean
	 * @param name
	 * @param requiredType
	 * @return
	 * @throws NotFoundException
	 */
	<T> T getBean(String name,Class<T> requiredType);
	
	
	
	/**
	 * ����������������õ�bean��ʵ��
	 * @param requiredType
	 * @return
	 * @throws NotFoundException
	 */
	<T> T getBean(Class<T> requiredType);
	
	
	/**
	 * �ж�beanʵ���Ƿ����
	 * @return
	 */
	boolean isExist(String name);
	
}
