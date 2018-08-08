package pro_servlet_jsp_thaithiloc.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import pro_servlet_jsp_thaithiloc.property.LoadingProperties;

import java.sql.PreparedStatement;

public class ConnectionDB {
	static PreparedStatement ps;
	static Connection con;
	static ResultSet rs;
	static LoadingProperties property;
//	static HashMap<String, String> proMap;
	

	/**
	 * 
	 */
	public ConnectionDB() {
		property  = new LoadingProperties();
	}
	/**
	 * Tao ket noi den CSDL voi cac thong tin ve URL cua DB, username va pass dan
	 * gnhap vao DB
	 * 
	 * @return con: luu tru thong tin ket noi CSDL
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		try {
//			HashMap<String, String> proMap = new LoadingProperties().readDBProperties("DB.properties");
//			property  = new LoadingProperties();
//			HashMap<String, String> proMap = property.readDBProperties("DB.properties");
//			String DB_URL = proMap.get("DB_URL").toString();
//			String USER_NAME = proMap.get("USER_NAME").toString();
//			String PASSWORD = proMap.get("PASSWORD").toString();
			String DB_URL = property.getValueOfProperty("DB_URL");
			String USER_NAME = property.getValueOfProperty("USER_NAME");
			String PASSWORD = property.getValueOfProperty("PASSWORD");
			// thiet lap ket noi
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connect successfully!");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			throw ce;
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (IOException ie) {
			ie.printStackTrace();
			throw ie;
		}
		return con;
	}

	/**
	 * Dong ket noi den CSDL voi dieu kien truoc do da thiet lap xong ket noi
	 * 
	 * @param con: thong tin ket noi da duoc thiet lap truoc do
	 * @throws SQLException
	 */
	public static void closeConnection(Connection con) throws SQLException {
		try {
			if (con != null) {
				con.close();
//				System.out.println("Disconnect successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Dong {@link PreparedStatement}
	 * 
	 * @param ps: luu thong tin khoi tao {@link PreparedStatement}
	 * @throws SQLException
	 */
	public static void closePrepareStatement(PreparedStatement ps) throws SQLException {
		try {
			if (ps != null) {
				ps.close();
//				System.out.println("Close successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Dong {@link ResultSet}
	 * 
	 * @param rs: luu thong tin khoi tao {@link ResultSet}
	 * @throws SQLException
	 */
	public static void closeResultSet(ResultSet rs) throws SQLException {
		try {
			if (rs != null) {
				rs.close();
//				System.out.println("Close successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

}