package org.summer.cyh.resolver;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.bean.FirstBeanDefine;
import org.summer.cyh.exception.NotBeAllowedOPerate;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;
import org.summer.cyh.resource.Resource;
import org.summer.cyh.util.JudgeTools;


/**
 * 该类用于定位bean以及解析bean的参数.继承该抽象类可以使用不同的解析XML的方法
 * 如果还有其他自定义的节点，那么在这里就可以扩展。这里针对于注解的方式也可以扩展。（在需要改的时候，在考虑是否稍微改动一下结构）
 * @author ChenYh
 *
 */
public abstract class AbstractResolver implements Resolver{

	private Resource resource; 	//资源
	private File file;			//文件 
	
	public AbstractResolver(Resource resource) throws NullParamException, NotMach, NotFoundException, NotBeAllowedOPerate {
		JudgeTools.NotAllowedNull(resource, "传入的文件不能为空......");
		this.resource = resource;
		this.file = resource.getCheackedFile();
	}
	
	@Override
	public Map<Boolean, List<Element>> focusFirstNode(String firstNodeName) {
		JudgeTools.NotAllowedNull(firstNodeName, "需要的节点的名字不能为空......");
		Document doc = getDocument();
		Element root = getRootElement(doc);
		return locationNode(root, firstNodeName);			
	}


	@Override
	public Map<String, FirstBeanDefine> parseNode(Map<Boolean, List<Element>> node) {
//		JudgeTools.NotAllowedNullParam(node, "需要得到的节点的参数名不能为空......");
		return parseFirstNodeParam(node);
	}

	
	
	@Override
	public Map<String, List<ChildBeanDefine>> parseSecondNode(
			List<Element> parentNode) {
		return parseSecondNodeParam(parentNode);
	}

	@Override
	public Object getInstance(Class<?> clazz) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * 得到文本的文档对象
	 * @return
	 */
	protected abstract Document getDocument() ;														//得到文档对象
	
	/**
	 * 
	 * @param doc 文档对象
	 * @return 返回根节点
	 */
	protected abstract Element getRootElement(Document doc);										//得到根节点
	
	/**
	 * 定位节点
	 * @param root 根节点对象
	 * @param requireNodeName 需要的节点的名字
	 * @param type 需要节点的类型
	 * @return
	 */
	protected abstract Map<Boolean, List<Element>> locationNode(Element root,String requireNodeName);	//解析node名字返回node对象
	
	/**
	 * 解析参数
	 * @param node 装节点的集合
	 * @return 返回封装了BeanDefine的数组
	 */
	protected abstract Map<String, FirstBeanDefine> parseFirstNodeParam(Map<Boolean, List<Element>> node);						//解析参数
	
	/**
	 * 解析第二个节点的参数
	 * @param parentNode 父节点
	 * @return 返回封装二级节点属性的Map
	 */
	protected abstract Map<String, List<ChildBeanDefine>> parseSecondNodeParam(List<Element> parentNode);

	
	protected File getFile(){
		return file;
	}
	
	protected Resource getResource(){
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
