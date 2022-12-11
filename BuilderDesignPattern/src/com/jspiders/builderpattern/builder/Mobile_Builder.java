package com.jspiders.builderpattern.builder;

import com.jspiders.builderpattern.object.Mobile;

public class Mobile_Builder {
	private String brand;
	private String model;
	private int ram;
	private int memory;
	private int front_cam;
	private int rear_cam;
	private double price;
	private int battery;
	private String color;
	private double processor;
	
	public Mobile_Builder brand(String brand) {
		this.brand=brand;
		return this;
	}
	public Mobile_Builder model(String model) {
		this.model=model;
		return this;
	}
	public Mobile_Builder ram(int ram) {
		this.ram=ram;
		return this;
	}
	public Mobile_Builder memory(int memory) {
		this.memory=memory;
		return this;
	}
	public Mobile_Builder front_cam(int front_cam) {
		this.front_cam=front_cam;
		return this;
	}
	public Mobile_Builder rear_cam(int rear_cam) {
		this.rear_cam=rear_cam;
		return this;
	}
	public Mobile_Builder price(double price) {
		this.price=price;
		return this;
	}
	public Mobile_Builder battery(int battery) {
		this.battery=battery;
		return this;
	}
	public Mobile_Builder color(String color) {
		this.color=color;
		return this;
	}
	public Mobile_Builder processor(double processor) {
		this.processor=processor;
		return this;
	}
	public Mobile getMobile() {
		Mobile mobile = new Mobile(this.brand,this.model,this.ram,this.memory,this.front_cam,this.rear_cam,this.price,this.battery,this.color,this.processor);
		return mobile;
	}
}
