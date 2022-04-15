package dev.mfaydali.data;

import java.util.List;

import dev.mfaydali.models.Employee;

public interface EmployeeDAO extends GenericDAO<Employee> {

	// set the generics type here since its inherited, set it to employee
	// a class that implements this interface will have the types as Employee public

	public int createEmployee(Employee e);

	public Employee getEmployee(int employeeId);

	public Employee getByUserName(String username);

	public List<Employee> getAllEmployees();

	public boolean updateEmployee(Employee e);

	public boolean deleteEmployee(int employeeId);


}
