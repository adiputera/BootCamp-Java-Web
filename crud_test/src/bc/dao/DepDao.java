package bc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bc.entity.Department;
import bc.entity.Employee;
import bc.util.DbUtil;

public class DepDao {
	public static int add(Department dep){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into departemen(id,nama_departemen,alamat,email) values (?,?,?,?)");  
            ps.setInt(1,dep.getId());  
            ps.setString(2,dep.getNamaDepartemen());  
            ps.setString(3,dep.getAlamat());  
            ps.setString(4,dep.getEmail());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int update(Department dep){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement(  
                         "update departemen SET nama_departemen=?,alamat=?,email=? where id=?");  
            ps.setString(1,dep.getNamaDepartemen());  
            ps.setString(2,dep.getAlamat());  
            ps.setString(3,dep.getEmail());    
            ps.setInt(4,dep.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement("delete from departemen where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
    
    public static Department getDepById(int id){  
        Department dep = new Department();  
          
        try{  
            Connection con= DbUtil.getConnect(); 
            PreparedStatement ps=con.prepareStatement("select * from departemen where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                dep.setId(rs.getInt(1));  
                dep.setNamaDepartemen(rs.getString(2));  
                dep.setAlamat(rs.getString(3));  
                dep.setEmail(rs.getString(4));    
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return dep;  
    }  
    
    public static List<Department> getAllDepartemen(){  
        List<Department> list=new ArrayList<Department>();  
          
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement("select * from departemen");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Department dep = new Department();  
                dep.setId(rs.getInt(1));  
                dep.setNamaDepartemen(rs.getString(2));  
                dep.setAlamat(rs.getString(3));  
                dep.setEmail(rs.getString(4));    
                list.add(dep);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
}
