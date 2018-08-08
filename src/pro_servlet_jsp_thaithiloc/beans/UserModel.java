package pro_servlet_jsp_thaithiloc.beans;

import java.io.Serializable;
import java.sql.Date;


public class UserModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date birthday;
	private String birthPlace;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}
	/**
	 * @param birthPlace the birthPlace to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	/**
	 * 
	 */
	public UserModel() {
		
	}
	/**
	 * @param id
	 * @param name
	 * @param birthday
	 * @param birthPlace
	 */
	public UserModel(int id, String name, Date birthday, String birthPlace) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.birthPlace = birthPlace;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("id:" + id + ", name: "+ name + ", bd:" + birthday + ", pl: "+ birthPlace);
	}
}
