<%@page import="bc.service.DepService"%>
<%@page import="bc.entity.Department"%>
<%@page import="bc.service.EmpService"%>
<%@page import="bc.control.EmployeeControlAdd"%>
<%@page import="bc.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/crud_test/assets/coba.css" type="text/css">
</head>
<body>
	

	<div id="container">
		<div id="header" class="customFont fontStyle">
			<div id="logo">
				<img src="/crud_test/img/logo2.png" width=115px> <img
					src="/crud_test/img/logoacademy.png" width=100px> <br> <img
					src="/crud_test/img/equine-logo.jpg" width=215px>
			</div>
		</div>
		<!--bisa 2 class dipanggil-->
		<!--end header-->
		<div id="menu">
			<ul class="utama">
				<li><a href="/crud_test/">Home</a></li>
				<li><a href="/crud_test/view/emp/view-emp.jsp">Employee</a></li>
				<li><a href="/crud_test/view/mhs/view-mhs.jsp">Mahasiswa</a></li>
				<li><a href="/crud_test/view/departm/view-dep.jsp">Departemen</a></li>
			</ul>
			<div style="clear: both"></div>
		</div>
		<div id="content">
			<div id="isi-content">
				<h2>Daftar Tabel Departemen</h2>
				<%
					List<Department> list = DepService.read();
					//foreach
				%>
				<table border="1" width=100%>
					<tr>
						<th>Id</th>
						<th>Nama Departemen</th>
						<th>Alamat</th>
						<th>Email</th>
						<th colspan=2>Edit / delete</th>
					</tr>
					<tr>
						<%
							for (Department e : list) {
								out.print("<tr><td>" + e.getId() + "</td><td>" + e.getNamaDepartemen() + "</td><td>" + e.getAlamat() + "</td><td>"
										+ e.getEmail() + "</td><td><a style='color:white;' href='edit-dep.jsp?id="+e.getId()+"'>edit</td>" + "<td><a style='color:white;' href='DepDel?id="+e.getId()+"'>delete</a></td></tr>");
							}
						%>
					</tr>
				</table>
				<a href="/crud_test/view/departm/add-dep.jsp" style="color:white;">Tambah Data</a>
			</div>
		</div>
		<!--end content-->
		<div id="nav"></div>
		<!--end nav-->
		<div style="clear: both"></div>
		<div id="footer">
			<h1>Bootcamp Java Batch 137</h1>
			<hr color="white">
			copyright &copy; Bootcamp 137. All Right Reserved.
		</div>
		<!--end footer-->
	</div>
	<!--end container-->

</body>
</html>