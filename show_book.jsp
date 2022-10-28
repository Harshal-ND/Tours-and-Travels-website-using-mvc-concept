<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/tour"  user="root" password=""/>
<sql:query dataSource="${db}"  var="rs">
select * from book;
</sql:query>

<h1 align="center"> BOOKING DETAILS!!</h1>
<table border="3px" align="center" cellpadding="5px" cellspacing="0px">
<tr>
<th> Booking Id</th>
<th> Name</th>

<th> Email</th>

<th> Mobile No.</th>
<th> Address</th>
<th> Where to go</th>
<th> How many passengers</th>
<th> Arrival Date</th>
<th> Leaving Date</th>

</tr>
<tr>
<c:forEach var="table" items="${rs.rows}">
</tr>
<tr>

<td><c:out value="${table.b_id}"/></td>
<td><c:out value="${table.b_name}"/></td>
<td><c:out value="${table.b_email}"/></td>
<td><c:out value="${table.b_cont_no}"/></td>
<td><c:out value="${table.b_address}"/></td>
<td><c:out value="${table.b_where_to}"/></td>
<td><c:out value="${table.b_how_many}"/></td>
<td><c:out value="${table.b_arrival}"/></td>
<td><c:out value="${table.b_leaving}"/></td>

</tr>

</c:forEach>
</table>
</body>
</html>