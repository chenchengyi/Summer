package org.summer.cyh.pools;
import org.summer.cyh.util.JudgeTools;

/**
 * ���ɽ������Ĺ�����,���øù����������Դ�����ͬ��XML������
 * @author ChenYh
 *
 */
public abstract class ParseTools{

	/**
	 * ������ͬ���͵Ľ�����
	 * @param classType
	 * @return
	 */
	public static <T> T createParseTool(Class<T> classType) {
		JudgeTools.NotAllowedNull(classType, "�����������Ͳ���Ϊ��......");
		T t =null;
		try {
			t= classType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	

}
