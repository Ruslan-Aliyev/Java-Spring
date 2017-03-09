# Spring Framework

### Project Set Up

![](https://raw.githubusercontent.com/atabegruslan/Java-Spring/master/Illustrations/spring1.PNG)

To include the needed .jars in Eclipse: Right click the project, Properties, Add an user library, add in the downloaded Spring jar files and the Apache Commons Logging jar file.

### Various ways of bean creation are shown

#### The main Java file

```java
public class Shape {

	public static void main(String[] args) {

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
```

#### The model Java files

```java
public class Triangle {
	public void draw(){
		System.out.println("Triangle");
	}
}			
```

```java
public class Square {
	public void draw(){
		System.out.println("Square");
	}
}			
```

```java
public class Circle {
	
	private String color;
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
		
	public void draw(){
		System.out.println(getColor() + " Circle");
	}
}		
```

```java
public class Face {
	
	private String mood;
	private int pixels;
	
	public Face (String mood, int pixels){
		this.mood = mood;
		this.pixels = pixels;
	}
	
	public String getMood(){
		return mood;
	}
	
	public int getPixels(){
		return pixels;
	}
				
	public void draw(){
		System.out.println(getMood() + " Face, " + getPixels() + " pixels");
	}
}		
```

#### The various configuration files needed for the various above Bean creation techniques

```xml
<beans>
    <bean id="triangle" class="org.ruslan.Triangle" />
    <bean id="square" class="org.ruslan.Square" />
</beans>				
```

```xml
<beans>
    <bean id="circle" class="org.ruslan.Circle">
    	<property name="color" value="red" />
    </bean>
</beans>				
```

```xml
<beans>
    <bean id="face" class="org.ruslan.Face">
    	<constructor-arg value="smiley" />
    	<constructor-arg type="int" value="30" />
    </bean>
</beans>				
```
