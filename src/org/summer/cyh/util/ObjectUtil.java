package org.summer.cyh.util;
/**
 * ���󹤾���
 * @author Administrator
 *
 */
public class ObjectUtil {

	
	/**
	 * �ж���������Ƿ�Ϊ��
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array){
		return (null == array || 0 == array.length);
	}
	
	
	/**
	 * ����������Ƿ��п�ֵ
	 * @param array
	 * @return
	 */
	public static boolean paramIsEmpty(Object[] array){
		
		for (Object object : array) {
			if(null==object){
				return true;
			}
		}
		
		return false;
	}

	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @param obj ����Ķ���
	 * @return �Ƿ�Ϊ��
	 */
	public static boolean isNull(Object obj){
		return (null == obj);
	}
	

}
