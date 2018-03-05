package bc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.entity.Employee;
import bc.service.EmpService;

@WebServlet("/EmployeeEdit")
public class EmployeeControlEdit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		String nama=req.getParameter("nama");
		String alamat=req.getParameter("alamat");
		String email=req.getParameter("email");
		
		Employee e=new Employee();
		e.setId(id);
		e.setNama(nama);
		e.setAlamat(alamat);
		e.setEmail(email);
		
		int status=EmpService.edit(e);
		if(status>0){
			resp.sendRedirect("view-emp.jsp");
		}else{
			out.println("Gagal");
		}
		
		out.close();
	}
}
