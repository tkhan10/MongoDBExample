/**
 * 
 */
package com.tofek.java.mongo.model;

/**
 * @author tofekkhan
 *
 */
public class User {

	private int id;
	private String name;
	private String role;
	private boolean isEmployee;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the isEmployee
	 */
	public boolean isEmployee() {
		return isEmployee;
	}
	/**
	 * @param isEmployee the isEmployee to set
	 */
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	
	
	

}
