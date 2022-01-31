package com.shun.sbprojects.dataobjects;

public class SalariedEmployee extends Employee 
{

	final int allowedMaxLeaves = 15;
	public SalariedEmployee(EmpType salaried) {
		super(salaried.toString());
	}
	
	
	@Override
	public int getAllowedMaxLeaves() {
		// TODO Auto-generated method stub
		return allowedMaxLeaves;
	}

}
