package org.summer.cyh.factory;
import org.summer.cyh.resource.Resource;

/**
 * ����θ������,ע�� ����bean�����ֺͶ�Ӧ����������MAp�������� .���ﻹ����beanDefine������һ������bean��������Ҫ��ʵ������
 * @author ChenYh
 *
 */
public class DefaultXmlBeanFactory extends AbstarctXmlBeanFactory{
	
	public DefaultXmlBeanFactory( Resource resouce) {
		super( resouce);
	}
	
//	@Override
//	public Object getBean(String name) {
//	
//		return super.getBean(name);
//	}
//
//
//	@Override
//	public <T> T getBean(String name, Class<T> requiredType) {
//		return super.getBean(name, requiredType);
//	}
//
//
//	@Override
//	public <T> T getBean(Class<T> requiredType) {
//		return super.getBean(requiredType);
//	}
//
//
//	@Override
//	public boolean isExist(String name) {
//		return super.isExist(name);
//	}

	/**
	 * ׼������������ں���Ҫ�� �����г���
	 */
	public void prepare(){
		this.registe();		//ע��
		this.parseAndParseSecondNode();//�����ڶ��ڵ�
	}
	
}
