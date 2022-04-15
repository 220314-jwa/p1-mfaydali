package dev.mfaydali.models;

import java.util.Objects;

public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int employeeId;
	private int managerId;
	private int deptId;


	public User(String username, String password, String firstName, String lastName, String email, int employeeId,
			int managerId, int deptId) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.deptId = deptId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(deptId, email, employeeId, firstName, lastName, managerId, password, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return deptId == other.deptId && Objects.equals(email, other.email) && employeeId == other.employeeId
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& managerId == other.managerId && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", employeeId=" + employeeId + ", managerId=" + managerId
				+ ", deptId=" + deptId + "]";
	}



}
