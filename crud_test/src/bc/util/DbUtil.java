package bc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbUtil {
static Connection connection = null;
	
	public static Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String username = "crud_test";
			String password = "crud";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static PreparedStatement preparedQuery(String sql) {
		PreparedStatement ps = null;
		try {
			ps = DbUtil.getConnect().prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ps;
	}
}
