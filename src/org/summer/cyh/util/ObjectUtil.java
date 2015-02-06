package org.summer.cyh.util;
/**
 * 对象工具类
 * @author Administrator
 *
 */
public class ObjectUtil {

	
	/**
	 * 判断数组对象是否为空
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array){
		return (null == array || 0 == array.length);
	}
	
	
	/**
	 * 检查数组中是否有空值
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
	 * 判断对象是否为空
	 * @param obj 传入的对象
	 * @return 是否为空
	 */
	public static boolean isNull(Object obj){
		return (null == obj);
	}
	

}
