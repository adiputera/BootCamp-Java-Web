package bc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.dao.EmpDao;
import bc.entity.Employee;
import bc.service.EmpService;

@WebServlet("/empcontrol")
public class EmployeeControl extends HttpServlet {
	EmpService es = new EmpService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String rdr = "";
        if (action.equalsIgnoreCase("delete")){
        	String sid=req.getParameter("id");
    		int uid=Integer.parseInt(sid);
    		EmpService.delete(uid);  
        } else if (action.equalsIgnoreCase("list")){
            req.setAttribute("emp", es.read());
        } else if(action.equalsIgnoreCase("readid")){
        	String sid=req.getParameter("id");
    		int id=Integer.parseInt(sid);
        	req.setAttribute("emp", es.readId(id));
        	
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/emp/view-emp.jsp");
		dispatcher.forward(req,resp);
        //RequestDispatcher view = req.getRequestDispatcher(forward);
        //view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equalsIgnoreCase("insert")) {
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
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/emp/view-emp.jsp");
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
			
			Employee e=new Employee();
			e.setId(id);
			e.setNama(nama);
			e.setAlamat(alamat);
			e.setEmail(email);
			
			int status=EmpService.edit(e);
			if(status>0){
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/emp/view-emp.jsp");
				dispatcher.forward(req,resp);
			}else{
				out.println("Gagal");
			}
			
			out.close();
		}
	}
}
