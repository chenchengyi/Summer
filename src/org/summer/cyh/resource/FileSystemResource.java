package org.summer.cyh.resource;

import java.io.File;
import org.summer.cyh.exception.NotBeAllowedOPerate;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;

/**
 * �ļ�ϵͳ��Դ final ��֤ CheakedFile()�İ�ȫ��
 * @author ChenYh
 *
 */
public class FileSystemResource extends AbstractResource{

	
	public FileSystemResource(File file){
		super(null, file);
	}
	
	public FileSystemResource(String filePath) {
		super(filePath,null);
	}
	
	public FileSystemResource(String filePath,File file){
		
		super(filePath,file);
	}

	@Override
	public boolean isExist() {
		return super.file.exists();
	}

	@Override
	public boolean canReadable() {
		return super.file.canRead();
	}

	@Override
	public boolean canWritable() {
		return super.file.canWrite();
	}
	

	@Override
	public File getCheackedFile() throws NullParamException, NotMach, NotFoundException, NotBeAllowedOPerate {
		File file  = setAndGetFile();				//���ļ�����ֵ
		
		if(!isExist()){
			throw new NotFoundException("�ļ�������......");
		}else if(!canReadable() || !canWritable()){
			throw new NotBeAllowedOPerate("�ļ�����������......");
		}else{
			return file;
		}
	}

}
