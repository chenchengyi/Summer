package test;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.summer.cyh.exception.NotBeAllowedOPerate;
import org.summer.cyh.exception.NotFoundException;
import org.summer.cyh.exception.NotMach;
import org.summer.cyh.exception.NullParamException;
import org.summer.cyh.resource.FileSystemResource;

public class FileSystemResourceTest {
	
	public static void main(String[] args) {
		String path = "F:/项目/mole_2.pdb";
		File file = new File("F:/项目/mole_2.pdb");
	
//		try {
//			
//			File file1 = new FileSystemResource(null, file).getCheackedFile();
//		} catch (NullParamException e) {
//			e.printStackTrace();
//		} catch (NotMach e) {
//			e.printStackTrace();
//		} catch (NotFoundException e) {
//			e.printStackTrace();
//		} catch (NotBeAllowedOPerate e) {
//			e.printStackTrace();
//		}
	}

}
