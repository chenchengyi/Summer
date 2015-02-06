package org.summer.cyh.resolver.handler;

import java.util.List;
import java.util.Map;

import org.jdom.Element;
import org.summer.cyh.bean.ChildBeanDefine;
import org.summer.cyh.bean.FirstBeanDefine;
import org.summer.cyh.bean.SecondBeanDefine;

/**
 * �����Ҫ��������ʽ�����ڵ�Ĳ�����������չ������
 * �ڵ�Ĳ���������
 * @author ChenYuh
 *
 */
public interface Handler {

	/**
	 * ����һ���ڵ�Ĳ���
	 * @param eleָ���Ľڵ�
	 * @return
	 */
	FirstBeanDefine handleBeanParam(Element ele,boolean hashChild);
	
	/**
	 * ����SecondBeanDefine�ڵ�Ĳ���
	 * @param ele ���ӽڵ�
	 * @return
	 */
	Map<String,List<ChildBeanDefine>> handleChildParam(Element ele);
	
	/**
	 * ����ָ���ڵ��ָ������
	 * @param ele 
	 * @param paramName
	 * @return
	 */
	String reutrnParam(Element ele,String paramName);

}
