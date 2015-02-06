package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Element;
import org.summer.cyh.bean.FirstBeanDefine;
import org.summer.cyh.bean.SecondBeanDefine;
import org.summer.cyh.resolver.JDomResolver;
import org.summer.cyh.resolver.Resolver;
import org.summer.cyh.resource.FileSystemResource;
import org.summer.cyh.resource.Resource;

public class JDomResolverTest{

	public static void main(String[] args) throws Exception{
		
		File  file = new File("book.xml");
		Resource re = new FileSystemResource(file);
		
			Resolver res = new JDomResolver(re);
			Map<Boolean, List<Element>> map = res.focusFirstNode("bean");
			Map<String, FirstBeanDefine> fb = res.parseNode(map);
			Iterator<String> it = fb.keySet().iterator();
			List<Element> list = new ArrayList<Element>();
			
			
			while(it.hasNext()){
				
//				System.out.println(fb.get(it.next()).getChildren()!=null?"":fb.get(it.next()).getChildren()[0]);
//				System.out.println(fb.get(it.next()));
				list.add(fb.get(it.next()).getNode());
			}
			
//			Map<String, SecondBeanDefine> mapChild = res.parseSecondNode(list);
//			Iterator<String> it1 = mapChild.keySet().iterator();
//			while(it1.hasNext()){
//				System.out.println(mapChild.get(it1.next()).getBeanDefineName());
//			}
	}

}
