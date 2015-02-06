package org.summer.cyh.exception;

/**
 * 文件不能被操作的异常
 * @author Administrator
 *
 */
public class NotBeAllowedOPerate extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5133472612728506653L;

	public NotBeAllowedOPerate() {
		super();
	}
	
	public NotBeAllowedOPerate(String msg){
		super(msg);
	}

}
