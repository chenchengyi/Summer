package org.summer.cyh.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Element;
import org.summer.cyh.bean.FirstBeanDefine;
import org.summer.cyh.bean.param.NodeParam;
import org.summer.cyh.exception.NotBeAllowedOPerate;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;
import org.summer.cyh.resolver.JDomResolver;
import org.summer.cyh.resource.Resource;

/**
 * 
 *
 * XMl文件处理的 : 负责解析器的初始化,负责初始化路径并定位 ,解析,Bean 初始化资源
 * @author ChenYh
 *
 *
 */
public class AbstarctXmlBeanFactory extends AbsractSingtonBeanFactory{
	
	private List<Element> allBeanNode = new ArrayList<Element>();	//所有的bean节点
	
	public AbstarctXmlBeanFactory(Resource resouce) {
		super(resouce);
		
		try {
			//初始化解析器
			setResolver(new JDomResolver(resouce));
		} catch (NullParamException e) {
			e.printStackTrace();
		} catch (NotMach e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (NotBeAllowedOPerate e) {
			e.printStackTrace();
		}
	}

	
	@Override
	protected Map<Boolean, List<Element>> locationBean() {
		
		return getResolver().focusFirstNode(NodeParam.BEAN);
	}
	

	@Override
	protected Map<String, FirstBeanDefine> parseNode() {
		
		Map<String, FirstBeanDefine> firstMap = getResolver().parseNode(locationBean());
		Iterator<String> it = firstMap.keySet().iterator();
		while(it.hasNext()){
			//得到所有的父节点
			allBeanNode.add(firstMap.get(it.next()).getNode());
		}
		return firstMap;
	}
	
	
	
	@Override
	protected void parseAndParseSecondNode() {
		
		setSecondNodeMap(getResolver().parseSecondNode(allBeanNode));
	}


	@Override
	protected void registe() {
		//将结果注册到容器
		setBeanMap(parseNode());
	}


	/**
	 * 得到文档中所有的Bean节点
	 * @return 文档中所有的Bean节点对象
	 */
	protected List<Element> getAllBeanNode(){
		return allBeanNode;
	}
	
}
