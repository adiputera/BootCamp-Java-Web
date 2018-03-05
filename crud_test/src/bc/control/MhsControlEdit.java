package bc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.entity.Employee;
import bc.entity.Mahasiswa;
import bc.service.EmpService;
import bc.service.MahasiswaService;

@WebServlet("/MhsEdit")
public class MhsControlEdit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		int status=MahasiswaService.edit(mhs);
		if(status>0){
			resp.sendRedirect("view-mhs.jsp");
		}else{
			out.println("Gagal");
		}
		
		out.close();
	}
}
