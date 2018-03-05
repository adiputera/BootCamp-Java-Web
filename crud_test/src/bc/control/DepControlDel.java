package bc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.service.DepService;
import bc.service.EmpService;

@WebServlet("/DepDel")
public class DepControlDel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		DepService.delete(id);
		resp.sendRedirect("view-dep.jsp");
	}
}
