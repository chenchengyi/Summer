package org.summer.cyh.util;

import org.summer.cyh.exception.NullParamException;

/**
 * �жϵĶ���� �������쳣����
 * @author ChenYh
 *
 */
public abstract class JudgeTools {

	
	/**
	 * ���������ֵΪ��
	 * @param o
	 * @throws NullParamException
	 */
	public static void NotAllowedNull(Object o,String msg){
		if(null == o){
			throw new IllegalArgumentException(msg);
		}else if(String.valueOf(o).equals("")){
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * �������Ƿ�Ϊ��
	 * @param array
	 * @param msg
	 */
	public static void NotEmpty(Object[] array,String msg){
		if(ObjectUtil.isEmpty(array)){
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * ���������鲻��Ϊ�� �������鲻���пյĲ���
	 * @param array
	 * @param msg
	 */
	public static void NotAllowedNullParam(Object[] array,String msg){
		if(ObjectUtil.paramIsEmpty(array) || ObjectUtil.paramIsEmpty(array)){
			throw new IllegalArgumentException(msg);
		}
	}
	
	
}

