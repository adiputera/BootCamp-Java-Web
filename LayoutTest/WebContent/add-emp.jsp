<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Insert Employee</h1>
	<form action="EmployeeAdd" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td>:</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>Nama</td>
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
				<td colspan="2"><input type="submit" value="Tambahkan employee" /></td>
			</tr>
		</table>
	</form>

	<br />
	<a href="view-emp.jsp">view employees</a>

</body>
</html>
