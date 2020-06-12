<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders Detail</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Order Details</h2></caption>
            <tr>
                <th>Driver</th>
                <th>Customer</th>
                <th>Status</th>
            </tr>
            <c:forEach var="entry" items="${data}">
                <tr>
                	
                    <td><c:out value="${entry[0]}" /></td>
                    <td><c:out value="${empty entry[1] ? '-' : entry[1]}" /></td>
                    <td><c:out value="${not entry[2] ? 'BOOKED' : 'AVAILABLE'}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>