package bc.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MahasiswaService extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");        
        String tb=req.getParameter("table");    
 
        try
        {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","CRUD_TEST","crud");
             Statement st=con.createStatement();
             System.out.println("connection established successfully...!!");     
 
             ResultSet rs=st.executeQuery("Select * from "+tb);
             
             pw.print("Data Mahasiswa : ");
             pw.println("<table border=1>");
                 while(rs.next())
                 {
                     pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td>"+
                                      "<td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
                 }
             pw.println("</table>");
             pw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
 
    }
}
