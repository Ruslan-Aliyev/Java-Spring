package org.ruslan;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Shape {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		// -- without using Spring
		//Triangle triangle = new Triangle();
		
		// -- using bean factory
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring1.xml"));		
		Triangle triangle = (Triangle) factory.getBean("triangle");
		triangle.draw();
		Square square = (Square) factory.getBean("square");
		square.draw();
		
		// -- using application context --- setter dependency injection
		ApplicationContext context = new ClassPathXmlApplicationContext("spring1a.xml");	
		Circle circle = (Circle) context.getBean("circle");
		circle.draw();
		
		// -- using application context --- constructor  dependency injection
		ApplicationContext context2 = new ClassPathXmlApplicationContext("spring1b.xml");	
		Face face = (Face) context2.getBean("face");
		face.draw();
	}

}
