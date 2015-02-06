package org.summer.cyh.util;

/**
 * 字符串的工具类
 * @author ChenYh
 *
 */
public abstract class StringUtil {

	/**
	 * 判断一个字符串是否是空字符创
	 * @param str 字符串
	 * @return 是否为空字符串
	 */
	static boolean isEmputyString(String str){
		
		JudgeTools.NotAllowedNull(str, "字符串对象NUll......");
		return "".equals(str.trim());
	}
	
	
//	static StringBuilder SET =new StringBuilder("set");
	
	static final char[] SET = {'s','e','t'};
	/**
	 * 将字符串首字母大写并在片面加set
	 * @param string
	 * @return
	 */
	public static String toUpCaseAndaddSet(String string){
		StringBuilder sb = new StringBuilder(string);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.insert(0, SET).toString();
	}

}
