package org.summer.cyh.util;

/**
 * �ַ����Ĺ�����
 * @author ChenYh
 *
 */
public abstract class StringUtil {

	/**
	 * �ж�һ���ַ����Ƿ��ǿ��ַ���
	 * @param str �ַ���
	 * @return �Ƿ�Ϊ���ַ���
	 */
	static boolean isEmputyString(String str){
		
		JudgeTools.NotAllowedNull(str, "�ַ�������NUll......");
		return "".equals(str.trim());
	}
	
	
//	static StringBuilder SET =new StringBuilder("set");
	
	static final char[] SET = {'s','e','t'};
	/**
	 * ���ַ�������ĸ��д����Ƭ���set
	 * @param string
	 * @return
	 */
	public static String toUpCaseAndaddSet(String string){
		StringBuilder sb = new StringBuilder(string);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.insert(0, SET).toString();
	}

}
