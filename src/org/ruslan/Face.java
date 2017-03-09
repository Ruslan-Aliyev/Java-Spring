package org.ruslan;

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
