package bc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.entity.Department;
import bc.entity.Employee;
import bc.service.DepService;
import bc.service.EmpService;

@WebServlet("/DepAdd")
public class DepControlAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String nama=req.getParameter("nama");
		String alamat=req.getParameter("alamat");
		String email=req.getParameter("email");
		
		Department dep = new Department();
		dep.setId(id);
		dep.setNamaDepartemen(nama);
		dep.setAlamat(alamat);
		dep.setEmail(email);
		
		int status= DepService.save(dep);;
		if(status>0){
			out.print("<p>Data Berhasil Disimpan</p>");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view-dep.jsp");
			dispatcher.forward(req,resp);
		}else{
			out.println("Gagal");
		}
		
		out.close();
	}
}
