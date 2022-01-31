<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateVacation</title>
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
<h2>Update Vacation Days</h2>

<form name="updateVacationDays" id="updateVacationDays" method="POST" action="updateVacationDays">
<table style="width:90%">
<tr style="text-align:left"><td>Employee ID<input type="hidden" id="empID" name="empID" value="${employeeRecord.empID}"></td><td>${employeeRecord.empID}</td></tr>
<tr><td>Employee Name</td><td>${employeeRecord.empName}</td></tr>
<tr><td>Number of VacationTaken</td><td>${employeeRecord.vacDaysUsed}</td></tr>
<tr><td>Vacation Need for Days</td><td><input type="number" id="newVacationDays" name="newVacationDays" min="0" max="${maxLeaveAllowed - employeeRecord.vacDaysUsed}" step="0.01"></td></tr>
</table>
<br>
<table>
<tr><td><button type="submit"  onclick="checkAndSubmit" >Update Vacation Days</button></td><td></td></tr>
</table>
</form>
</body>
</html>