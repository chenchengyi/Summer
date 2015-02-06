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
 * �������ڶ�λbean�Լ�����bean�Ĳ���.�̳иó��������ʹ�ò�ͬ�Ľ���XML�ķ���
 * ������������Զ���Ľڵ㣬��ô������Ϳ�����չ�����������ע��ķ�ʽҲ������չ��������Ҫ�ĵ�ʱ���ڿ����Ƿ���΢�Ķ�һ�½ṹ��
 * @author ChenYh
 *
 */
public abstract class AbstractResolver implements Resolver{

	private Resource resource; 	//��Դ
	private File file;			//�ļ� 
	
	public AbstractResolver(Resource resource) throws NullParamException, NotMach, NotFoundException, NotBeAllowedOPerate {
		JudgeTools.NotAllowedNull(resource, "������ļ�����Ϊ��......");
		this.resource = resource;
		this.file = resource.getCheackedFile();
	}
	
	@Override
	public Map<Boolean, List<Element>> focusFirstNode(String firstNodeName) {
		JudgeTools.NotAllowedNull(firstNodeName, "��Ҫ�Ľڵ�����ֲ���Ϊ��......");
		Document doc = getDocument();
		Element root = getRootElement(doc);
		return locationNode(root, firstNodeName);			
	}


	@Override
	public Map<String, FirstBeanDefine> parseNode(Map<Boolean, List<Element>> node) {
//		JudgeTools.NotAllowedNullParam(node, "��Ҫ�õ��Ľڵ�Ĳ���������Ϊ��......");
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
	 * �õ��ı����ĵ�����
	 * @return
	 */
	protected abstract Document getDocument() ;														//�õ��ĵ�����
	
	/**
	 * 
	 * @param doc �ĵ�����
	 * @return ���ظ��ڵ�
	 */
	protected abstract Element getRootElement(Document doc);										//�õ����ڵ�
	
	/**
	 * ��λ�ڵ�
	 * @param root ���ڵ����
	 * @param requireNodeName ��Ҫ�Ľڵ������
	 * @param type ��Ҫ�ڵ������
	 * @return
	 */
	protected abstract Map<Boolean, List<Element>> locationNode(Element root,String requireNodeName);	//����node���ַ���node����
	
	/**
	 * ��������
	 * @param node װ�ڵ�ļ���
	 * @return ���ط�װ��BeanDefine������
	 */
	protected abstract Map<String, FirstBeanDefine> parseFirstNodeParam(Map<Boolean, List<Element>> node);						//��������
	
	/**
	 * �����ڶ����ڵ�Ĳ���
	 * @param parentNode ���ڵ�
	 * @return ���ط�װ�����ڵ����Ե�Map
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
