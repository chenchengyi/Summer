package test;

import java.io.File;

import org.summer.cyh.factory.DefaultXmlBeanFactory;
import org.summer.cyh.resource.FileSystemResource;
import org.summer.cyh.resource.Resource;

import test.org.cyh.model.ModelB;

public class AllTest {

	public static void main(String[] args) {
		File  file = new File("book.xml");
		Resource re = new FileSystemResource(file);
		DefaultXmlBeanFactory de = new DefaultXmlBeanFactory(re);
		de.prepare();
		ModelB b = (ModelB)de.getBean("B");
		
		b.getModelA().test();
		b.getModelC().test();
		
	}

}
