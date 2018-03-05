package bc.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.control.EmployeeControl;
import bc.entity.Employee;

public class EmployeeAdd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        int id=Integer.parseInt(request.getParameter("id"));
	        String nama=request.getParameter("nama");  
	        String alamat=request.getParameter("alamat");  
	        String email=request.getParameter("email");    
	          
	        Employee emp=new Employee();  
	        emp.setId(id);  
	        emp.setNama(nama);  
	        emp.setAlamat(alamat);  
	        emp.setEmail(email);  
	          
	        int status=EmployeeControl.add(emp);  
	        if(status>0){  
	            out.print("<p>Data Berhasil disimpan!</p>");  
	            request.getRequestDispatcher("add-emp.html").include(request, response);  
	        }else{  
	            out.println("Gagal");  
	        }  
	          
	        out.close();  
	    }
}
