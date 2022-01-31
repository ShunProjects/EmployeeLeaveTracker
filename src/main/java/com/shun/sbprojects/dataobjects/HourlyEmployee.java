package com.shun.sbprojects.dataobjects;

public class HourlyEmployee  extends Employee {

	
	final int allowedMaxLeaves = 10;
	public HourlyEmployee(EmpType hourly) {
		super(hourly.toString());
	}

	@Override
	public int getAllowedMaxLeaves() {
		// TODO Auto-generated method stub
		return this.allowedMaxLeaves;
	}

}
