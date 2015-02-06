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
 * XMl�ļ������ : ����������ĳ�ʼ��,�����ʼ��·������λ ,����,Bean ��ʼ����Դ
 * @author ChenYh
 *
 *
 */
public class AbstarctXmlBeanFactory extends AbsractSingtonBeanFactory{
	
	private List<Element> allBeanNode = new ArrayList<Element>();	//���е�bean�ڵ�
	
	public AbstarctXmlBeanFactory(Resource resouce) {
		super(resouce);
		
		try {
			//��ʼ��������
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
			//�õ����еĸ��ڵ�
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
		//�����ע�ᵽ����
		setBeanMap(parseNode());
	}


	/**
	 * �õ��ĵ������е�Bean�ڵ�
	 * @return �ĵ������е�Bean�ڵ����
	 */
	protected List<Element> getAllBeanNode(){
		return allBeanNode;
	}
	
}
