package org.summer.cyh.bean;

import org.summer.cyh.util.JudgeTools;
/**
 * *�����������һ���ڵ��bean���ƣ����Դ�������չ
 * �����beanDefine ���һЩֵ�ó�ʼ���Ĺ���
 * @author ChenYuh
 *
 */
public abstract class AbstractBeanDefine implements FirstBeanDefine{
	
	private boolean isLazyInit;			//�Ƿ��ӳټ���
	private boolean isSingleton;		//�Ƿ��ǵ���
	private String clazz;				//������(�磺com.cyh.Test)
	private String beanDefineName;		//beanDefine������
	private String[] beans;				//������bean������
	
	public AbstractBeanDefine() {
		// TODO Auto-generated constructor stub
	}
	
	public AbstractBeanDefine(String beanDefineName) {
		JudgeTools.NotAllowedNull(beanDefineName,"bean���ֲ���Ϊ��......");
		this.beanDefineName = beanDefineName;
	}
	
	@Override
	public void setChild(String beanId) {
		setChildren(new String[]{beanId});
	}

	
	@Override
	public void setChildren(String[] beanIds) {
		
		JudgeTools.NotEmpty(beanIds, "�����beanId���鲻��Ϊ��......");
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
