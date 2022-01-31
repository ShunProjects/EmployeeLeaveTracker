package com.shun.sbprojects.dataobjects;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Employee {
	
	
	String empID;
	String empName;
	String empType;
	int totalNoOfWorkingDays;
	int numberOfDaysWorked;
	float vacDaysUsed;
	float accVacationDays;

	public static enum EmpType   { HOURLY, SALARIED,MANAGER};

	public Employee(String empType)
	{
		this.empType=empType;
		this.accVacationDays=0.0f;
		this.vacDaysUsed=0.0f;
		this.numberOfDaysWorked=0;
		this.totalNoOfWorkingDays=260;
	}
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public float getAccVacationDays() {
		return accVacationDays;
	}
	public void setAccVacationDays(float accVacationDays) {
		this.accVacationDays = accVacationDays;
	}
	public int getNumberOfDaysWorked() {
		return numberOfDaysWorked;
	}
	public void setNumberOfDaysWorked(int numberOfDaysWorked) {
		this.numberOfDaysWorked = numberOfDaysWorked;
	}
	public float getVacDaysUsed() {
		return vacDaysUsed;
	}
	public void setVacDaysUsed(float vacDaysUsed) {
		this.vacDaysUsed = vacDaysUsed;
	}

	public int getTotalNoOfWorkingDays() {
		return totalNoOfWorkingDays;
	}

	public void setTotalNoOfWorkingDays(int totalNoOfWorkingDays) {
		this.totalNoOfWorkingDays = totalNoOfWorkingDays;
	}
	
	public void updateWorkingDays(int newWorkingDays)
	{
		this.numberOfDaysWorked=this.numberOfDaysWorked+newWorkingDays;
		updateAccVacation();
	}
	
	public void updateVactionTaken(float newVacationDays) 
	{
		this.vacDaysUsed = this.vacDaysUsed+newVacationDays;
		
	}
	public void updateAccVacation() 
	{
	
		System.out.println("Total Max Leaves ->> "+this.getAllowedMaxLeaves());
		System.out.println("No of Days Workd ->> "+this.numberOfDaysWorked);
		System.out.println("Total Number of Working Days --> " +this.totalNoOfWorkingDays);
		System.out.println("Employe Type --> "+this.empType);
		float accuredLeaves= (float)this.numberOfDaysWorked/(float)this.totalNoOfWorkingDays * this.getAllowedMaxLeaves();
		BigDecimal bdecimal = new BigDecimal(accuredLeaves).setScale(2, RoundingMode.HALF_UP);
		accuredLeaves=bdecimal.floatValue();
		System.out.println("Total Accured Leaves -->> "+accuredLeaves);
		this.accVacationDays=accuredLeaves;
	}
	
	abstract public int getAllowedMaxLeaves();
	
}
