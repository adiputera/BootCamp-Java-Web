<%@page import="bc.control.EmployeeControl"%>
<%@page import="bc.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Daftar Tabel Employee</h2>
	<%
		List<Employee> list=EmployeeControl.getAllEmployees();
		//foreach
	%>
	<table border="1" width=100%>
		<tr>
			<th>Id</th>
			<th>Nama</th>
			<th>Alamat</th>
			<th>Email</th>
			<th colspan=2>Edit / delete</th>
		</tr>
		<tr>
			<%
				for(Employee e:list){  
			      	out.print("<tr><td>"+e.getId()+
			    		"</td><td>"+e.getNama()+
			    		"</td><td>"+e.getAlamat()+
			    		"</td><td>"+e.getEmail()+
			    		"</td><td><a href='EmployeeEdit?id="
			    		+e.getId()+"'>edit</a></td>"  
			            +"<td><a href='EmployeeDel?id="
			    		+e.getId()+"'>delete</a></td></tr>");  
				}
			%>
		</tr>
	</table>
	
</body>
</html>