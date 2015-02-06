package org.summer.cyh.exception;

/**
 * 传入参数为空的错误
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
