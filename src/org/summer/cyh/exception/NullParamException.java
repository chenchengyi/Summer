package org.summer.cyh.exception;

/**
 * �������Ϊ�յĴ���
 * @author ChenYh
 *
 */
public class NullParamException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1886254643333276829L;

	public NullParamException() {
		super();
	}
	
	public NullParamException(String msg){
		super(msg);
	}

}
