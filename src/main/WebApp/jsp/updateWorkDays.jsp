<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Work Days</title>
<style>
table, th, td {
  border: 1px solid white;
  border-collapse: collapse;
}
th, td {
  background-color: #96D4D4;
}
</style>
</head>
<body>
<h2>Update Working Days</h2>

<form name="updateWorkDaysForm" id="updateWorkDaysForm" method="POST" action="updateWorkDays">
<table style="width:90%">
<tr style="text-align:left"><td>Employee ID<input type="hidden" id="empID" name="empID" value="${employeeRecord.empID}"></td><td>${employeeRecord.empID}</td></tr>
<tr><td>Employee Name</td><td>${employeeRecord.empName}</td></tr>
<tr><td>Number of Days Worked</td><td>${employeeRecord.numberOfDaysWorked}</td></tr>
<tr><td>Current Working Days</td><td><input type="number" id="newWorkingDays" name="newWorkingDays" min="0" max="${employeeRecord.totalNoOfWorkingDays - employeeRecord.numberOfDaysWorked}"></td></tr>
</table>
<br>
<table>
<tr><td><button type="submit"  onclick="checkAndSubmit" >Update Working Days</button></td><td></td></tr>
</table>
</form>
</body>
</html>