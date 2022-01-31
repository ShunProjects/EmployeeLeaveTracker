package com.shun.sbprojects.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shun.sbprojects.dataobjects.Employee;
import com.shun.sbprojects.dataobjects.HourlyEmployee;
import com.shun.sbprojects.dataobjects.ManagerEmployee;
import com.shun.sbprojects.dataobjects.SalariedEmployee;

@Controller
public class LeaveTrackerController {


	 @RequestMapping("listAllEmployees")
	 public String listAllEmployees(HttpSession session)
	 {
		 HashMap<String,Employee> employeeTable= (HashMap<String, Employee>) session.getAttribute("EMPLOYEETABLE");
		 
		 if (employeeTable == null)
		 {
			 employeeTable=initializeData();
		 }
		 session.setAttribute("EMPLOYEETABLE", employeeTable);
		 return "allEmployeesReport";
	 }
	 
	 @PostMapping("showWorkDays")
	 public String showWorkDays(@RequestParam("empID") String empID, Model model,HttpSession session)
	 {
		 
		 Employee employeeRecord = getEmployeeRecord(empID,session);
		 model.addAttribute("employeeRecord",employeeRecord);
		 
		 return "updateWorkDays";
	 }
	
	 @PostMapping("showVacationTaken")
	 public String showVacationTaken(@RequestParam("empID") String empID, Model model,HttpSession session)
	 {
		 //System.out.println("Employee ID "+empID);
		 Employee employeeRecord = getEmployeeRecord(empID,session);
		 //System.out.println("Max Leaves Allowed " + employeeRecord.getAllowedMaxLeaves());		 
		 model.addAttribute("employeeRecord",employeeRecord);
		 model.addAttribute("maxLeaveAllowed",employeeRecord.getAllowedMaxLeaves());
		 return "updateVacationTaken";
	 }
	 
	 
	 @PostMapping("updateWorkDays")
	 public String updateWorkDays(@RequestParam("empID") String empID,@RequestParam("newWorkingDays") int newWorkingDays, Model model,HttpSession session)
	 {
		 
//		 System.out.println("Employee ID "+empID);
//		 System.out.println("New Working Days"+newWorkingDays);
		 Employee employeeRecord = getEmployeeRecord(empID,session);
		 employeeRecord.updateWorkingDays(newWorkingDays);
		 updateEmployeeRecord(employeeRecord,session);
		 return "allEmployeesReport";
	 }
	 

	 @PostMapping("updateVacationDays")
	 public String updateVacationDays(@RequestParam("empID") String empID,@RequestParam("newVacationDays") float newVacationDays, Model model,HttpSession session)
	 {
		 
		 System.out.println("Employee ID "+empID);
		 System.out.println("New Working Days"+newVacationDays);
		 Employee employeeRecord = getEmployeeRecord(empID,session);
		 employeeRecord.updateVactionTaken(newVacationDays);
		 updateEmployeeRecord(employeeRecord,session);
		 return "allEmployeesReport";
	 }

	 /**
	  * Initialize the HashMap with sample data.
	  * 
	  * @return
	  */
	 
	 public HashMap<String, Employee> initializeData()
	 {
		 HashMap<String,Employee> employeeData = new HashMap<String, Employee>();
		 
		 //Create 10 Hourly Employees
		 
		 for (int i=1; i<=10;i++)
		 {
			 Employee hrlyEmployee = new HourlyEmployee(Employee.EmpType.HOURLY);
			 hrlyEmployee.setEmpID(hrlyEmployee.getEmpType()+"_"+i);
			 hrlyEmployee.setEmpName(hrlyEmployee.getEmpType()+"_"+i);
			 employeeData.put(hrlyEmployee.getEmpID(), hrlyEmployee);
		 }
		 
		 //Create 10 Salaried Employees
		 
		 for (int i=1; i<=10;i++)
		 {
			 Employee salariedEmployee = new SalariedEmployee(Employee.EmpType.SALARIED);
			 salariedEmployee.setEmpID(salariedEmployee.getEmpType()+"_"+i);
			 salariedEmployee.setEmpName(salariedEmployee.getEmpType()+"_"+i);
			 employeeData.put(salariedEmployee.getEmpID(), salariedEmployee);
		 }

		 
		 //Create 10 Manager Employees
		 
		 for (int i=1; i<=10;i++)
		 {
			 Employee mgrEmployee = new ManagerEmployee(Employee.EmpType.MANAGER);
			 mgrEmployee.setEmpID(mgrEmployee.getEmpType()+"_"+i);
			 mgrEmployee.setEmpName(mgrEmployee.getEmpType()+"_"+i);
			 employeeData.put(mgrEmployee.getEmpID(), mgrEmployee);
		 }

		 return employeeData;
	 }
	 
	 
	 /**
	  * To get a single Employee Record from the Session
	  */
	 public Employee getEmployeeRecord(String empID,HttpSession session)
	 {
		 Employee employeeRecord = null;
		 
		 HashMap<String,Employee> employeeTable = (HashMap<String, Employee>) session.getAttribute("EMPLOYEETABLE");
		 
		 if (employeeTable != null)
		 {
			 //System.out.println("Employee ID"+empID);
			 employeeRecord = employeeTable.get(empID);
		 }
		 return employeeRecord;
	 }
	 
	 /**
	  * Update a single employ record and replace in the EMPLOYEETABLE
	  * 
	  */
	 
	 public void updateEmployeeRecord(Employee employeeRecord,HttpSession session)
	 {
		 
		 HashMap<String,Employee> employeeTable = (HashMap<String, Employee>) session.getAttribute("EMPLOYEETABLE");

		 if (employeeTable != null)
		 {
			 //System.out.println("Updating Employee ID"+employeeRecord.getEmpID());
			 employeeTable.put(employeeRecord.getEmpID(), employeeRecord);
			 
		 }
		 session.setAttribute("EMPLOYEETABLE", employeeTable);
	 }
	 
}
