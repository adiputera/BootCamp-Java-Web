package bc.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.control.EmployeeControl;
import bc.entity.Employee;

@WebServlet("/EmployeeEdit")  
public class EmployeeEdit extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        String nama=request.getParameter("nama");  
	        String alamat=request.getParameter("alamat");  
	        String email=request.getParameter("email");    
	          
	        Employee emp=new Employee();  
	        emp.setId(id);  
	        emp.setNama(nama);  
	        emp.setAlamat(alamat);  
	        emp.setEmail(email);    
	          
	        int status=EmployeeControl.update(emp);  
	        if(status>0){  
	            response.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	    }
}
