package org.summer.cyh.bean;
/**
 * 二级节点的BeanDefine接口
 * @author ChenYuh
 *如果有其他参数，在这里可以扩展
 */
public interface SecondBeanDefine extends BaseBeanDefine{
	
	/**
	 * 设置父节点的Id
	 * @param parentId 父节点的Id
	 */
	void setParentId(String parentId);
	
	/**
	 * 得到父节点的Id
	 * @return 父节点的id
	 */
	String getParentId();
	
}
