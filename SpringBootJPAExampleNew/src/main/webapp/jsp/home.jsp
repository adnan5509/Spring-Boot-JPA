<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Employee Portal</title>
</head>
<body>
<h2>Add Employee</h2>
<form action="addEmployee">
<label for="eid">Employee ID:</label><input type="text" name="eid"><br>
<label for="ename">Employee Name:</label><input type ="text" name = "ename"><br>
<label for="eDesignation">Employee Designation:</label><input type ="text" name = "eDesignation"><br>
<label for="eSalary">Employee Salary:</label><input type ="text" name = "eSalary"><br>
<input type="submit">
</form>

<br>
<br>
<br>

<h2>View All Employees</h2>
<form action="getAllEmployee">
<input type="submit" value="View All">
</form>

<br>
<br>
<br>

<h2>Get Employee</h2>
<form action="getEmployee">
<label for="getEmployeeId">Employee ID:</label><input type="text" name="getEmployeeId"><br>
<input type="submit">
</form>

<br>
<br>
<br>

<h2>Get Employee By Designation</h2>
<form action="getEmployeeByDesignation">
<label for="employeeDesignation">Employee Designation:</label><input type="text" name="employeeDesignation"><br>
<input type="submit">
</form>

<br>
<br>
<br>

<h2>Get Employees with Salary Greater Than</h2>
<form action="getEmployeeWithGreaterSalary">
<label for="salaryGreaterThan">Employee Salary:</label><input type="text" name="salaryGreaterThan"><br>
<input type="submit">
</form>

<br>
<br>
<br>

<h2>Get Employees Due for a Raise</h2>
<form action="getEmployeesDueForRaise">
<label for="employeeRaiseDesignation">Employee Designation:</label><input type="text" name="employeeRaiseDesignation"><br>
<label for="employeeRaiseSalary">Employee Salary:</label><input type="text" name="employeeRaiseSalary"><br>
<input type="submit">
</form>

<br>
<br>
<br>

<h2>Update Employee Salary</h2>
<form action="updateEmployeeSalary">
<label for="updateEmployeeId">Employee ID:</label><input type="text" name="updateEmployeeId"><br>
<label for="updatedSalary">Employee Salary:</label><input type ="text" name = "updatedSalary"><br>
<input type="submit">
</form>

</body>
</html>