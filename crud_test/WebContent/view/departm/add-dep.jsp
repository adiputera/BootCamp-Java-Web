<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
				<h1>Insert Departemen</h1>
				<form action="/crud_test/DepAdd" method="post">
					<table>
						<tr>
							<td>ID</td>
							<td>:</td>
							<td><input type="text" name="id" /></td>
						</tr>
						<tr>
							<td>Nama Departemen</td>
							<td>:</td>
							<td><input type="text" name="nama" /></td>
						</tr>
						<tr>
							<td>Alamat</td>
							<td>:</td>
							<td><input type="text" name="alamat" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td>:</td>
							<td><input type="email" name="email" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit"
								value="Tambahkan Departemen" /></td>
						</tr>
					</table>
				</form>
				<br /> <a href="view-dep.jsp">view Departemen</a>
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
