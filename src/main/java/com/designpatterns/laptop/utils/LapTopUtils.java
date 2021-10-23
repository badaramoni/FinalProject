package com.designpatterns.laptop.utils;

public class LapTopUtils {
	
	public static final int HIGH = 3;
	public static final int MEDIUM = 2;
	public static final int LOW = 1;
	public static final int OFF = 0;
	
	String location;
	int speed;
 
	public LapTopUtils(String location) {
		this.location = location;
	}
  
	public void high() {
		// turns the laptop memory on to high
		speed = HIGH;
		System.out.println(location + " laptop memory is on high");
	} 

	public void medium() {
		// turns the laptop memory on to medium
		speed = MEDIUM;
		System.out.println(location + " laptop memory is on medium");
	}

	public void low() {
		// turns the laptop memory on to low
		speed = LOW;
		System.out.println(location + " laptop memory is on low");
	}
 
	public void off() {
		// turns the laptop memory off
		speed = OFF;
		System.out.println(location + " laptop memory is off");
	}
 
	public int getSpeed() {
		return speed;
	}
}
