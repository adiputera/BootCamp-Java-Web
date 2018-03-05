package bc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bc.entity.Employee;
import bc.util.DbUtil;

public class EmpDao {
	public static int add(Employee emp){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into employee(id,nama,alamat,email) values (?,?,?,?)");  
            ps.setInt(1,emp.getId());  
            ps.setString(2,emp.getNama());  
            ps.setString(3,emp.getAlamat());  
            ps.setString(4,emp.getEmail());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int update(Employee e){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement(  
                         "update employee SET nama=?,alamat=?,email=? where id=?");  
            ps.setString(1,e.getNama());  
            ps.setString(2,e.getAlamat());  
            ps.setString(3,e.getEmail());    
            ps.setInt(4,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement("delete from employee where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
    
    public static Employee getEmployeeById(int id){  
        Employee emp=new Employee();  
          
        try{  
            Connection con= DbUtil.getConnect(); 
            PreparedStatement ps=con.prepareStatement("select * from employee where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                emp.setId(rs.getInt(1));  
                emp.setNama(rs.getString(2));  
                emp.setAlamat(rs.getString(3));  
                emp.setEmail(rs.getString(4));    
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return emp;  
    }  
    
    public static List<Employee> getAllEmployees(){  
        List<Employee> list=new ArrayList<Employee>();  
          
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement("select * from employee");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Employee emp=new Employee();  
                emp.setId(rs.getInt(1));  
                emp.setNama(rs.getString(2));  
                emp.setAlamat(rs.getString(3));  
                emp.setEmail(rs.getString(4));    
                list.add(emp);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
}
