package org.summer.cyh.util;

import org.summer.cyh.exception.NullParamException;

/**
 * 判断的额工具类 并进行异常处理
 * @author ChenYh
 *
 */
public abstract class JudgeTools {

	
	/**
	 * 不允许传入的值为空
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
	 * 看数组是否为空
	 * @param array
	 * @param msg
	 */
	public static void NotEmpty(Object[] array,String msg){
		if(ObjectUtil.isEmpty(array)){
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * 不允许数组不能为空 并且数组不能有空的参数
	 * @param array
	 * @param msg
	 */
	public static void NotAllowedNullParam(Object[] array,String msg){
		if(ObjectUtil.paramIsEmpty(array) || ObjectUtil.paramIsEmpty(array)){
			throw new IllegalArgumentException(msg);
		}
	}
	
	
}

