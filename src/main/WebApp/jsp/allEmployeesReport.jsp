<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
function checkAndSubmit(actionType) 
{
	let x = document.forms["employessReportForm"]["empID"].value;
	//alert ("Select EmpID"+x);
	//alert ("Action Type"+actionType)
	if (x == "")
	{
		alert ("Select an Employee before submitting");
	}
	else 
	{
		if (actionType == 'Work' )
		{
			document.forms.employessReportForm.action="showWorkDays";
			document.forms.employessReportForm.method="POST";
			document.forms.employessReportForm.submit();
		}
		else if (actionType == 'Vacation')
			{
			document.forms.employessReportForm.action="showVacationTaken";
			document.forms.employessReportForm.method="POST";
			document.forms.employessReportForm.submit();
			}
	}
}
</script>

<meta charset="ISO-8859-1">
<title>All Employees List</title>
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


<%@ page import = "java.io.*,java.util.*,javax.servlet.http.HttpSession" %>
<%@ page import = "com.shun.sbprojects.dataobjects.Employee" %>




<body>
<h2>Employee Leave Tracker Application - For LabCorp</h2>
<form name="employessReportForm" id="employessReportForm" method="POST">

<table style="width:90%">
<tr style="text-align:left">
<th >Select Employee</th>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Number of Days Worked</th>
<th>Vacation Taken</th>
</tr>

<% 
HashMap<String, Employee> employeeTable =  (HashMap<String, Employee>) session.getAttribute("EMPLOYEETABLE");
if (employeeTable != null)
{
	
	for (Map.Entry<String,Employee> recordSet: employeeTable.entrySet()) 
	{
		String strEmpId = recordSet.getKey();
		Employee employeeRecord = recordSet.getValue();
%>
    	<tr>
    	<td><input type="radio" id="empID" name="empID" value="<%=strEmpId%>">
	    <td><%=strEmpId%></td>
	    <td><%=employeeRecord.getEmpName()%></td>
	  	<td><%=employeeRecord.getNumberOfDaysWorked()%></td>
	    <td><%=employeeRecord.getVacDaysUsed()%></td>
	    </tr>
<%
	}
%>			
</table>
<table>
<tr>
<td><button type="button"  onclick="checkAndSubmit('Work')" >Update Working Days</button></td>
<td><button type="button" onclick="checkAndSubmit('Vacation')" >Update Vacation Days</button></td>
</table>
	
<%
	}
%>


</form>
</body>
</html>