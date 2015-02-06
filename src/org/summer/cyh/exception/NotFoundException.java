package org.summer.cyh.exception;

/**
 * 找不到bean对象
 * @author Administrator
 *
 */

public class NotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7798951933938574953L;

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String msg) {
		super(msg);
	}

}
