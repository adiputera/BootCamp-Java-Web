package bc.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.control.EmployeeControl;
import bc.entity.Employee;

@WebServlet("/EmployeeView")
public class EmployeeRead extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
     response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     out.println("<a href='index.html'>Add New Employee</a>");  
     out.println("<h1>Employees List</h1>");  
       
     List<Employee> list=EmployeeControl.getAllEmployees();  
       
     out.print("<table border='1' width='100%'");  
     out.print("<tr><th>Id</th>"
     		+ "<th>Nama</th>"
     		+ "<th>Alamat</th>"
     		+ "<th>Email</th>"  
            + "<th>Edit</th>"
            + "<th>Delete</th></tr>");  
     for(Employee e:list){  
      out.print("<tr><td>"+e.getId()+
    		  "</td><td>"+e.getNama()+
    		  "</td><td>"+e.getAlamat()+
    		  "</td><td>"+e.getEmail()+
    		  "</td><td><a href='EmployeeEdit?id="
    		  +e.getId()+"'>edit</a></td>"  
              +"<td><a href='EmployeeDel?id="
    		  +e.getId()+"'>delete</a></td></tr>");  
     }  
     out.print("</table>");  
       
     out.close();  
 }  
}
