package pro_servlet_jsp_thaithiloc.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pro_servlet_jsp_thaithiloc.beans.UserModel;
import pro_servlet_jsp_thaithiloc.property.LoadingProperties;

public class DBUtils extends ConnectionDB {
	
	/**
	 * 
	 */
	public DBUtils() {
		super();
	}

	public static List<UserModel> getListUser() {
		String ERROR_MSG = null;
		List<UserModel> listUser = new ArrayList<UserModel>();
		try {
//			HashMap<String, String> proMap = new LoadingProperties().readDBProperties("errorMsg.properties");
//			ERROR_MSG = proMap.get("ERROR_MSG").toString();
//			property  = new LoadingProperties();
			ERROR_MSG = property.getValueOfErrProperty("ERROR_MSG");
			con = getConnection();
			ps = con.prepareStatement("select * from user_loctt.user;");
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel us = new UserModel();
				us.setId(rs.getInt("Id"));
				us.setName(rs.getString("Name"));
				us.setBirthday(rs.getDate("Birthday"));
				us.setBirthPlace(rs.getString("BirthPlace"));
				listUser.add(us);
			}
		} catch (SQLException e) {
			System.out.println(ERROR_MSG);
		} catch (ClassNotFoundException e) {
			System.out.println(ERROR_MSG);
		} catch (IOException e) {
			System.out.println(ERROR_MSG);
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(ERROR_MSG);
			}
		}
		return listUser;
	}

	public static void main(String[] args) {
		UserModel user;
		DBUtils dbUntils = new DBUtils();
		List<UserModel> list = dbUntils.getListUser();
		for (int i = 0; i < list.size(); i++) {
			user = list.get(i);
			System.out.println(user.toString());
		}
	}
}
