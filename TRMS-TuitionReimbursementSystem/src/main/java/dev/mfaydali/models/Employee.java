package dev.mfaydali.models;

public class Employee {
	// let's determine fields
	private int employeeId;
	private int managerId;
	private int deptId;
	private String firstName;
	private String lastName;

	// Constructor
	public Employee() {
		this.employeeId = 0;
		this.managerId = 0;
		this.deptId = 0;
		this.firstName = "";
		this.lastName = "";
	}


	public Employee(int i, int j, int k, String string, String string2) {
		// TODO Auto-generated constructor stub
	}


	// getter and setters
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

	public String getfName() {
		return firstName;
	}

	public void setfName(String fName) {
		this.firstName = fName;
	}

	public String getLname() {
		return lastName;
	}

	public void setLname(String lname) {
		this.lastName = lname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptId;
		result = prime * result + employeeId;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + managerId;
		return result;
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
		if (deptId != other.deptId)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (managerId != other.managerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", managerId=" + managerId + ", deptId=" + deptId + ", firstName="
				+ firstName + ", lastname=" + lastName + "]";
	}


}
