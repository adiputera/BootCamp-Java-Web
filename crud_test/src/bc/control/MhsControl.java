package bc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.entity.Employee;
import bc.entity.Mahasiswa;
import bc.service.EmpService;
import bc.service.MahasiswaService;

@WebServlet("/mhscontrol")
public class MhsControl extends HttpServlet {
	MahasiswaService ms = new MahasiswaService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String rdr = "";
        if (action.equalsIgnoreCase("delete")){
        	String sid=req.getParameter("nim");
    		ms.delete(sid);  
        } else if (action.equalsIgnoreCase("list")){
            req.setAttribute("emp", ms.read());
        } else if(action.equalsIgnoreCase("readid")){
        	String sid=req.getParameter("nim");
        	req.setAttribute("emp", ms.readId(sid));
        	
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/mhs/view-mhs.jsp");
		dispatcher.forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equalsIgnoreCase("insert")) {
			PrintWriter out=resp.getWriter();
			
			String nim = req.getParameter("nim");
			String nama=req.getParameter("nama");
			String alamat=req.getParameter("alamat");
			String univ=req.getParameter("univ");
			
			Mahasiswa mhs=new Mahasiswa();
			mhs.setNim(nim);
			mhs.setNama(nama);
			mhs.setAlamat(alamat);
			mhs.setUniv(univ);
			
			int status= ms.save(mhs);;
			if(status>0){
				out.print("<p>Data Berhasil Disimpan</p>");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/mhs/view-mhs.jsp");
				dispatcher.forward(req,resp);
			}else{
				out.println("Gagal");
			}
			
			out.close();
		}
		else if(action.equalsIgnoreCase("edit")) {
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			
			String nim=req.getParameter("nim");
			String nama=req.getParameter("nama");
			String alamat=req.getParameter("alamat");
			String univ=req.getParameter("univ");
			
			Mahasiswa mhs=new Mahasiswa();
			mhs.setNim(nim);
			mhs.setNama(nama);
			mhs.setAlamat(alamat);
			mhs.setUniv(univ);
			
			int status=ms.edit(mhs);
			if(status>0){
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/mhs/view-mhs.jsp");
				dispatcher.forward(req,resp);
			}else{
				out.println("Gagal");
			}
			
			out.close();
		}
	}
}
