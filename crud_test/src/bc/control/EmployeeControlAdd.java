package bc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.dao.EmpDao;
import bc.entity.Employee;
import bc.service.EmpService;

@WebServlet("/EmployeeAdd")
public class EmployeeControlAdd extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String nama=req.getParameter("nama");
		String alamat=req.getParameter("alamat");
		String email=req.getParameter("email");
		
		Employee e=new Employee();
		e.setId(id);
		e.setNama(nama);
		e.setAlamat(alamat);
		e.setEmail(email);
		
		int status= EmpService.save(e);;
		if(status>0){
			out.print("<p>Data Berhasil Disimpan</p>");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view-emp.jsp");
			dispatcher.forward(req,resp);
		}else{
			out.println("Gagal");
		}
		
		out.close();
	}
}
