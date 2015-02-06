package org.summer.cyh.bean;

/**
 * 用于包装 bean的 接口
 * @author Administrator
 *
 */
public interface FirstBeanDefine extends BaseBeanDefine{
	
	/**
	 * 设置是否延迟加载
	 * @param isLazyInit
	 */
	void setLazyInit(boolean isLazyInit);
	
	/**
	 * 返回是否延迟加载
	 * @return
	 */
	boolean isLazyInit();
	
	
	/**
	 * 设置是否是单例
	 * @param SingleTon
	 */
	void setSingleton(boolean isSingleton);
	
	/**
	 * 返回是否是单例 
	 * @return 是否是单例
	 */
	boolean isSingleton();
	
	/**
	 * 设置节点的注入节点(单个)
	 * @param beanId 节点的Id 即ref
	 */
	void setChild(String beanId);
	
	/**
	 * 设置节点的注入节点(多个)
	 * @param beanIds 节点的Id 即ref
	 */
	void setChildren(String[] beanIds);
	
	/**
	 * 返回该节点的所有的注入(property)的节点
	 * @return
	 */
	String[] getChildren();
	
	
	/**
	 * 设置bean的class里面的值
	 * @param clazz
	 */
	void setClazz(String clazz);
	
	
	String getClazz();
	
}
