package org.summer.cyh.resource;

import java.io.File;
import org.summer.cyh.exception.NotBeAllowedOPerate;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;

/**
 * 文件系统资源 final 保证 CheakedFile()的安全性
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
		File file  = setAndGetFile();				//给文件对象赋值
		
		if(!isExist()){
			throw new NotFoundException("文件不存在......");
		}else if(!canReadable() || !canWritable()){
			throw new NotBeAllowedOPerate("文件不允许被操作......");
		}else{
			return file;
		}
	}

}
