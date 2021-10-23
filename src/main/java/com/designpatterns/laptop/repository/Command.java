package com.designpatterns.laptop.repository;

public interface Command {
	public void execute();
	public void undo();
}