package org.ruslan;

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

