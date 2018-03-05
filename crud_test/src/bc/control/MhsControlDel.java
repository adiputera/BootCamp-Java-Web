package bc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.service.EmpService;
import bc.service.MahasiswaService;
@WebServlet("/MhsDel")
public class MhsControlDel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nim=req.getParameter("nim");
		MahasiswaService.delete(nim);
		resp.sendRedirect("view-mhs.jsp");
	}
}
