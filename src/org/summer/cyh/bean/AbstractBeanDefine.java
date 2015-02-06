package org.summer.cyh.bean;

import org.summer.cyh.util.JudgeTools;
/**
 * *如果有其他的一级节点和bean类似，可以从这里扩展
 * 抽象的beanDefine 完成一些值得初始化的功能
 * @author ChenYuh
 *
 */
public abstract class AbstractBeanDefine implements FirstBeanDefine{
	
	private boolean isLazyInit;			//是否延迟加载
	private boolean isSingleton;		//是否是单例
	private String clazz;				//类名字(如：com.cyh.Test)
	private String beanDefineName;		//beanDefine的名字
	private String[] beans;				//依赖的bean的名字
	
	public AbstractBeanDefine() {
		// TODO Auto-generated constructor stub
	}
	
	public AbstractBeanDefine(String beanDefineName) {
		JudgeTools.NotAllowedNull(beanDefineName,"bean名字不能为空......");
		this.beanDefineName = beanDefineName;
	}
	
	@Override
	public void setChild(String beanId) {
		setChildren(new String[]{beanId});
	}

	
	@Override
	public void setChildren(String[] beanIds) {
		
		JudgeTools.NotEmpty(beanIds, "传入的beanId数组不能为空......");
		this.beans = new String[beanIds.length];
		for(int i=0;i<beanIds.length;i++){
			this.beans[i] = beanIds[i];
		}
	}

	
	@Override
	public String[] getChildren() {
		return this.beans;
	}

	
	@Override
	public String getBeanDefineName() {
		return beanDefineName;
	}

	
	@Override
	public void setLazyInit(boolean isLazyInit) {
		this.isLazyInit = isLazyInit;
	}

	
	@Override
	public boolean isLazyInit() {
		return isLazyInit;
	}

	
	@Override
	public void setSingleton(boolean isSingleton){
		this.isSingleton = isSingleton;
	}

	
	@Override
	public boolean isSingleton() {
		return isSingleton;
	}
	
	public String getClazz() {
		return clazz;
	}

	@Override
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
}
