package com.tarena.netctoss.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tarena.netctoss.entity.Privilege;

public class PrivilegeReader {
	private static List<Privilege> modules = new ArrayList<Privilege>();
	static{
		InputStream xml = PrivilegeReader.class.getClassLoader().getResourceAsStream("privileges.xml");
		modules = toModuleList(xml);
	}
	public static List<Privilege> getPrivilege(){
		return modules;
	}
	public static String findPrivileNamegeById(String id){
		for(Privilege privilege : modules){
			if(privilege.getId().equals(id)){
				return privilege.getName();
			}
		}
		return "";
	}
	public static List<Privilege> toModuleList(InputStream xml){
		List<Privilege> modules = new ArrayList<Privilege>();
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(xml);
			Element root = doc.getRootElement();
			List<Element> moduleElements = root.elements("privilege");
			for( Element moduleElement : moduleElements){
				Privilege module = new Privilege();
				module.setId(moduleElement.attributeValue("id"));
				module.setName(moduleElement.elementText("name"));
				Element urlElement = moduleElement.element("urls");
				List<Element> urlElements = urlElement.elements("url");
				for(Element url : urlElements){
					module.getUrls().add(url.getText());
				}
				modules.add(module);
				
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return modules;
	}
	public static void main(String[] args){
		System.out.println(modules.get(0).getUrls());
	}
}
