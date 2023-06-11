package org.jsp.springlifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestByBeanFactory {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("test.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println(factory);
		System.out.println(factory);
	}
}
