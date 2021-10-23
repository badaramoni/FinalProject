package com.designpatterns.laptop.utils;

import com.designpatterns.laptop.repository.Command;


public class LapTopMediumCommand implements Command {
	
	
	LapTopUtils lapTop;
	int prevSpeed;

	public LapTopMediumCommand(LapTopUtils lapTop) {
		this.lapTop = lapTop;
	}
	public void execute() {
		prevSpeed = lapTop.getSpeed();
		lapTop.medium();
	}
	public void undo() {
		switch (prevSpeed) {
		case LapTopUtils.HIGH: 	lapTop.high(); break;
		case LapTopUtils.MEDIUM: lapTop.medium(); break;
		case LapTopUtils.LOW: 	lapTop.low(); break;
		default: 				lapTop.off(); break;
		}
	}
}