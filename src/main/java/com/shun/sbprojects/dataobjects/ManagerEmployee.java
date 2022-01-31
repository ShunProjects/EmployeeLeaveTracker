package com.shun.sbprojects.dataobjects;

public class ManagerEmployee extends Employee 
{

	final int allowedMaxLeaves = 30;

	
	public ManagerEmployee(EmpType manager) {
		super(manager.toString());
	}

	@Override
	public int getAllowedMaxLeaves() {

		return allowedMaxLeaves;
	}
	

}
