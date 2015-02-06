package org.summer.cyh.factory;
import org.summer.cyh.resource.Resource;

/**
 * 本层次负责解析,注册 ，将bean的名字和对应的类名放在MAp容器里面 .这里还负责将beanDefine创建成一个个的bean并返回需要的实例对象
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
	 * 准备环境：这个在后期要改 ：进行抽象
	 */
	public void prepare(){
		this.registe();		//注册
		this.parseAndParseSecondNode();//解析第二节点
	}
	
}
