package bc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bc.entity.Employee;
import bc.entity.Mahasiswa;
import bc.util.DbUtil;

public class MhsDao {
	public static int add(Mahasiswa mhs){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into mahasiswa(nim,nama,alamat,universitas) values (?,?,?,?)");  
            ps.setString(1,mhs.getNim());  
            ps.setString(2,mhs.getNama());  
            ps.setString(3,mhs.getAlamat());  
            ps.setString(4,mhs.getUniv());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int update(Mahasiswa mhs){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement(  
                         "update mahasiswa SET nama=?,alamat=?,universitas=? where nim=?");  
            ps.setString(1,mhs.getNama());  
            ps.setString(2,mhs.getAlamat());  
            ps.setString(3,mhs.getUniv());    
            ps.setString(4,mhs.getNim());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int delete(String nim){  
        int status=0;  
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement("delete from mahasiswa where nim=?");  
            ps.setString(1,nim);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
    
    public static Mahasiswa getMahasiswaById(String nim){  
        Mahasiswa mhs=new Mahasiswa();  
          
        try{  
            Connection con= DbUtil.getConnect(); 
            PreparedStatement ps=con.prepareStatement("select * from mahasiswa where nim=?");  
            ps.setString(1,nim);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                mhs.setNim(rs.getString(1));  
                mhs.setNama(rs.getString(2));  
                mhs.setAlamat(rs.getString(3));  
                mhs.setUniv(rs.getString(4));    
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return mhs;  
    }  
    
    public static List<Mahasiswa> getAllMahasiswa(){  
        List<Mahasiswa> list=new ArrayList<Mahasiswa>();  
          
        try{  
            Connection con= DbUtil.getConnect();  
            PreparedStatement ps=con.prepareStatement("select * from mahasiswa");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Mahasiswa mhs=new Mahasiswa();  
                mhs.setNim(rs.getString(1));  
                mhs.setNama(rs.getString(2));  
                mhs.setAlamat(rs.getString(3));  
                mhs.setUniv(rs.getString(4));    
                list.add(mhs);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
}
