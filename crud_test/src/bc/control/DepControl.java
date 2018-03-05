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

@WebServlet("/depcontrol")
public class DepControl extends HttpServlet{
	DepService ds = new DepService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
        	String sid=req.getParameter("id");
    		int uid=Integer.parseInt(sid);
    		DepService.delete(uid);  
        } else if (action.equalsIgnoreCase("list")){
            req.setAttribute("emp", ds.read());
        } else if(action.equalsIgnoreCase("readid")){
        	String sid=req.getParameter("id");
    		int id=Integer.parseInt(sid);
        	req.setAttribute("emp", ds.readId(id));
        	
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/departm/view-dep.jsp");
		dispatcher.forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equalsIgnoreCase("insert")) {
			PrintWriter out=resp.getWriter();
			
			int id = Integer.parseInt(req.getParameter("id"));
			String nama=req.getParameter("namaDepartemen");
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
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/departm/view-dep.jsp");
				dispatcher.forward(req,resp);
			}else{
				out.println("Gagal");
			}
			
			out.close();
		}
		else if(action.equalsIgnoreCase("edit")) {
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
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/departm/view-dep.jsp");
				dispatcher.forward(req,resp);
			}else{
				out.println("Gagal");
			}
			
			out.close();
		}
	}
}
