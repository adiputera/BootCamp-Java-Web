<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="bc.entity.Employee"%>
<%@page import="bc.service.EmpService"%>
<html>
	<head>
		<title>template</title>
		<link rel="stylesheet" href="/crud_test/assets/coba.css" type="text/css">
	</head>
	<body>
		
		<div id="container">
			<div id="header" class="customFont fontStyle">
				<div id="logo">
					<img src="/crud_test/img/logo2.png" width=115px>
					<img src="/crud_test/img/logoacademy.png" width=100px>
					<br>
				<img src="/crud_test/img/equine-logo.jpg" width=215px>
				</div>
			</div><!--bisa 2 class dipanggil--><!--end header-->
			<div id="menu">
			<ul class="utama">
				<li><a href="/crud_test/">Home</a></li>
				<li><a href="/crud_test/view/emp/view-emp.jsp">Employee</a></li>
				<li><a href="/crud_test/view/mhs/view-mhs.jsp">Mahasiswa</a></li>
				<li><a href="/crud_test/view/departm/view-dep.jsp">Departemen</a></li>
			</ul>
			<div style="clear:both"></div>
			</div>
			<div id="content">
				<div id="isi-content">
					<%
						String sid=request.getParameter("id");
						int id=Integer.parseInt(sid);
						Employee emp = EmpService.readId(id);
					%>
					<h1>Update Employee</h1>
					<form action='/crud_test/empcontrol?action=edit' method='post'>
						<table>
							<% 
								out.print("<tr><td>ID</td><td>:</td><td><input type='text' name='id' value='"+emp.getId()+"' readonly/></td></tr>");
							%>
							<%
								out.print("<tr><td>Nama</td><td>:</td><td><input type='text' name='nama' value='"+emp.getNama()+"'/></td></tr>");
							%>
							<%
								out.print("<tr><td>Alamat</td><td>:</td><td><input type='text' name='alamat' value='"+emp.getAlamat()+"'/></td></tr>");
							%>
							<%
								out.print("<tr><td>Email</td><td>:</td><td><input type='text' name='email' value='"+emp.getEmail()+"'/></td></tr>");
							%>
							<%
								out.print("<tr><td colspan='2'><input type='submit' value='Simpan'/></td></tr>");
							%>
						</table>
					</form>
				</div>
			</div><!--end content-->
			<div id="nav">
				
			</div><!--end nav-->
			<div style="clear:both"></div>
			<div id="footer">
				<h1>Bootcamp Java Batch 137</h1>
				<hr color="white">
				copyright &copy; Bootcamp 137. All Right Reserved.
			</div><!--end footer-->
		</div><!--end container-->
	</body>
</html>