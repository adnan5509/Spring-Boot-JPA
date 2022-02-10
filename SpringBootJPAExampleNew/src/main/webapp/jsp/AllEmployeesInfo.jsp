<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Employee Portal</title>
</head>
<body>
<table>
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Employee Designation</th>
        <th>Employee Salary</th>
    </tr>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.eid}</td>
            <td>${employee.ename}</td>
            <td>${employee.eDesignation}</td>
            <td>${employee.eSalary}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>