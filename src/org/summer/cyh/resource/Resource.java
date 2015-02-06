package org.summer.cyh.resource;

import java.io.File;
import java.io.InputStream;

import org.summer.cyh.exception.NotBeAllowedOPerate;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;

/**
 * ����Դ
 * @author ChenYh
 *
 */
public interface Resource {

	/**
	 * �ļ��Ƿ����
	 * @return
	 */
	boolean isExist();
	
	
	/**
	 * �ļ��Ƿ��
	 * @return
	 */
	boolean isOpen();
	
	/**
	 * �ļ��Ƿ�ɶ�
	 * @return
	 */
	boolean canReadable();
	
	/**
	 * �ļ��Ƿ��д
	 * @return
	 */
	boolean canWritable();
	
	
	/**
	 * �����ļ�����
	 * @return
	 */
	File getFile() throws NullParamException, NotMach;
	
	/**
	 * �����ļ�������
	 * @return
	 */
	InputStream getInputStream();
	
	
	/**
	 * ���ؼ����ļ�
	 * @return
	 * @throws NullParamException
	 * @throws NotMach
	 * @throws NotFoundException
	 * @throws NotBeAllowedOPerate
	 */
	File getCheackedFile() throws NullParamException, NotMach, NotFoundException, NotBeAllowedOPerate ;
	
	
}
