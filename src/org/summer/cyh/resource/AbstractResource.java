package org.summer.cyh.resource;

import java.io.File;
import java.io.InputStream;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;

/**
 * 抽象的资源
 * @author ChenYh
 *
 */
public abstract class AbstractResource implements Resource{
	protected String filePath;				//将所有子类的共同路径 文件路径抽象在这里
	protected File file;					//外部直接传入的文件资源
	
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
		 * 这里需要处理（D:\FILES\谷歌下载\经典）与(D:/FILES/谷歌下载/经典)相等的问题
		 */
		if(null != this.file){
			
			if(file.getPath().equals(filePath) || null==filePath){
				return this.file;
			}else{
				throw new NotMach("文件和路径不匹配......");
			}
			
		}else{
			
			if(null != this.filePath){
				return new File(this.filePath);
			}else{
				throw new NullParamException("文件和路径都为空......");
			}
		}
		
	}
	
	/**
	 * 给文件赋值
	 * @return 
	 * @throws NullParamException
	 * @throws NotMach
	 */
	protected File setAndGetFile() throws NullParamException, NotMach{
		file = getFile();
		return file;
	}

}
