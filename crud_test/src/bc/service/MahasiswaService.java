package bc.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bc.dao.MhsDao;
import bc.entity.Employee;
import bc.entity.Mahasiswa;

public class MahasiswaService extends HttpServlet {
	static MhsDao mdao = new MhsDao();
	public static int save(Mahasiswa mhs) {
		int status = mdao.add(mhs);
		return status;
	}
	
	public static int edit(Mahasiswa mhs) {
		int status = mdao.update(mhs);
		return status;
	}
	
	public static int delete(String nim) {
		int status = mdao.delete(nim);
		return status;
	}
	
	public static List<Mahasiswa> read() {
		return mdao.getAllMahasiswa();
	}
	
	public static Mahasiswa readId(String nim) {
		return mdao.getMahasiswaById(nim);
	}
}
