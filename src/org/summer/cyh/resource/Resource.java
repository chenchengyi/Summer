package org.summer.cyh.resource;

import java.io.File;
import java.io.InputStream;

import org.summer.cyh.exception.NotBeAllowedOPerate;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;

/**
 * 数据源
 * @author ChenYh
 *
 */
public interface Resource {

	/**
	 * 文件是否存在
	 * @return
	 */
	boolean isExist();
	
	
	/**
	 * 文件是否打开
	 * @return
	 */
	boolean isOpen();
	
	/**
	 * 文件是否可读
	 * @return
	 */
	boolean canReadable();
	
	/**
	 * 文件是否可写
	 * @return
	 */
	boolean canWritable();
	
	
	/**
	 * 返回文件对象
	 * @return
	 */
	File getFile() throws NullParamException, NotMach;
	
	/**
	 * 返回文件流对象
	 * @return
	 */
	InputStream getInputStream();
	
	
	/**
	 * 返回检查的文件
	 * @return
	 * @throws NullParamException
	 * @throws NotMach
	 * @throws NotFoundException
	 * @throws NotBeAllowedOPerate
	 */
	File getCheackedFile() throws NullParamException, NotMach, NotFoundException, NotBeAllowedOPerate ;
	
	
}
