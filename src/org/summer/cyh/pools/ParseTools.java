package org.summer.cyh.pools;
import org.summer.cyh.util.JudgeTools;

/**
 * 生成解析器的工厂类,调用该工厂方法可以创建不同的XML解析器
 * @author ChenYh
 *
 */
public abstract class ParseTools{

	/**
	 * 创建不同类型的解析器
	 * @param classType
	 * @return
	 */
	public static <T> T createParseTool(Class<T> classType) {
		JudgeTools.NotAllowedNull(classType, "传入的类的类型不能为空......");
		T t =null;
		try {
			t= classType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	

}
