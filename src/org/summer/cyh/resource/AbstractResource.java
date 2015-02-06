package org.summer.cyh.resource;

import java.io.File;
import java.io.InputStream;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;

/**
 * �������Դ
 * @author ChenYh
 *
 */
public abstract class AbstractResource implements Resource{
	protected String filePath;				//����������Ĺ�ͬ·�� �ļ�·������������
	protected File file;					//�ⲿֱ�Ӵ�����ļ���Դ
	
	public AbstractResource() {
	}
	
	public AbstractResource(String filePath,File file) {
		this.filePath = filePath;
		this.file = file;
	}

	@Override
	public boolean isExist() {
		return false;
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public boolean canReadable() {
		return false;
	}
	
	@Override
	public boolean canWritable() {
		return false;
	}
	
	@Override
	public InputStream getInputStream() {
		return null;
	}

	@Override
	public File getFile() throws NullParamException, NotMach {
		/**
		 * ???????????????????????????????
		 * ������Ҫ����D:\FILES\�ȸ�����\���䣩��(D:/FILES/�ȸ�����/����)��ȵ�����
		 */
		if(null != this.file){
			
			if(file.getPath().equals(filePath) || null==filePath){
				return this.file;
			}else{
				throw new NotMach("�ļ���·����ƥ��......");
			}
			
		}else{
			
			if(null != this.filePath){
				return new File(this.filePath);
			}else{
				throw new NullParamException("�ļ���·����Ϊ��......");
			}
		}
		
	}
	
	/**
	 * ���ļ���ֵ
	 * @return 
	 * @throws NullParamException
	 * @throws NotMach
	 */
	protected File setAndGetFile() throws NullParamException, NotMach{
		file = getFile();
		return file;
	}

}
