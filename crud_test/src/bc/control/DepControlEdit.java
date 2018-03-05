package bc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.entity.Department;
import bc.entity.Employee;
import bc.service.DepService;
import bc.service.EmpService;

@WebServlet("/DepEdit")
public class DepControlEdit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		String nama=req.getParameter("nama");
		String alamat=req.getParameter("alamat");
		String email=req.getParameter("email");
		
		Department dep=new Department();
		dep.setId(id);
		dep.setNamaDepartemen(nama);
		dep.setAlamat(alamat);
		dep.setEmail(email);
		
		int status=DepService.edit(dep);
		if(status>0){
			resp.sendRedirect("view-dep.jsp");
		}else{
			out.println("Gagal");
		}
		
		out.close();
	}
}
