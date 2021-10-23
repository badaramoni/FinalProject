package com.designpatterns.laptop.utils;

import com.designpatterns.laptop.repository.Command;

public class LapTopHighCommand implements Command {
	
	
	LapTopUtils laptop;
	int prevSpeed;

	public LapTopHighCommand(LapTopUtils laptop) {
		this.laptop = laptop;
	}
	public void execute() {
		prevSpeed = laptop.getSpeed();
		laptop.high();
	}
	public void undo() {
		switch (prevSpeed) {
		case LapTopUtils.HIGH: 	laptop.high(); break;
		case LapTopUtils.MEDIUM: laptop.medium(); break;
		case LapTopUtils.LOW: 	laptop.low(); break;
		default: 				laptop.off(); break;
		}
	}
}