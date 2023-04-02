package com.assignment.utility;

public class GenerateID {
	//TO keep LAST Created Student Roll Number
	static private int studentRollNumber = 1;
	

	public static int getNewRollNumber() {
		return studentRollNumber++;
	}
}