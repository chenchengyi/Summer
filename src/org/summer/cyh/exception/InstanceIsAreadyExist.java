package org.summer.cyh.exception;
/**
 * 实例已经存在
 * @author Administrator
 *
 */
public class InstanceIsAreadyExist extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6622891860095182228L;

	public InstanceIsAreadyExist() {
		super();
	}
	
	public InstanceIsAreadyExist(String msg) {
		super(msg);
	}

}
