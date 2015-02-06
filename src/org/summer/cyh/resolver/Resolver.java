package org.summer.cyh.resolver;

import java.util.List;
import java.util.Map;

import org.jdom.Element;
import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.bean.FirstBeanDefine;

/**
 * ��������Դ�Ľӿ�
 * @author ChenYh
 *
 */
public interface Resolver {
	
	
	/**
	 * ��λһ���ڵ�
	 * @param firstNodeName һ���ڵ������(�磺bean)
	 * @return �������е�һ���ڵ�Ķ����Map �к��ӽڵ��keyΪtrue��û�е�Ϊfalse
	 */
	Map<Boolean, List<Element>> focusFirstNode(String firstNodeName);
	
	
	/**
	 * ��BeanDefine��װ��һ��Map�� 
	 * @param list ��Ҫ�����Ľڵ�
	 * @return ����װ��beanDefine��map
	 */
	Map<String, FirstBeanDefine> parseNode(Map<Boolean, List<Element>> node);
	
	
	/**
	 * �������ڵ�ķ�װ��һ��Map����
	 * @param parentNode һ���ڵ����
	 * @return �����ڵ��Map
	 */
	Map<String, List<ChildBeanDefine>> parseSecondNode(List<Element> parentNode);
	
	
	/**
	 * ���ظ����ʵ������
	 * @param clazz
	 * @return
	 */
	Object getInstance(Class<?> clazz);
	
}
