package dev.mfaydali.models;

import java.util.Objects;

public class Employee {
	// let's determine fields
	private int employeeId;
	private int managerId;
	private int deptId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;


	public Employee(int employeeId, int managerId, int deptId, String firstName, String lastName, String username,
			String password) {
		super();
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.deptId = deptId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}


	public Employee() {
		// TODO Auto-generated constructor stub
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


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", managerId=" + managerId + ", deptId=" + deptId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", username=" + username + ", password=" + password + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(deptId, employeeId, firstName, lastName, managerId, password, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return deptId == other.deptId && employeeId == other.employeeId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && managerId == other.managerId
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}







}
