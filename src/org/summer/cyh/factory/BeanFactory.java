package org.summer.cyh.factory;


/**
 * bean工厂接口
 * @author ChenYh
 *
 */
public interface BeanFactory {

	/**
	 * 根据名字得到bean实例
	 * @param name
	 * @return
	 */
	Object getBean(String name) ;
	
	
	/**
	 * 根据类型和bean的名字拿到对应的bean
	 * @param name
	 * @param requiredType
	 * @return
	 * @throws NotFoundException
	 */
	<T> T getBean(String name,Class<T> requiredType);
	
	
	
	/**
	 * 根据所需的类型来拿到bean的实例
	 * @param requiredType
	 * @return
	 * @throws NotFoundException
	 */
	<T> T getBean(Class<T> requiredType);
	
	
	/**
	 * 判断bean实例是否存在
	 * @return
	 */
	boolean isExist(String name);
	
}
