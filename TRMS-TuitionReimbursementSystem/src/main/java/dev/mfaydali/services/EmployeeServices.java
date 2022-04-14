package dev.mfaydali.services;

import java.util.List;

import dev.mfaydali.data.EmployeeDAO;
import dev.mfaydali.exceptions.EmployeeAlreadyExistsException;
import dev.mfaydali.exceptions.EmployeeNotFoundException;
import dev.mfaydali.exceptions.RequestNotFoundException;
import dev.mfaydali.models.Employee;
import dev.mfaydali.models.Request;


public interface EmployeeServices {

	public Employee loginEmployee(int employeeId) throws EmployeeNotFoundException;

	public Request request(int requestId) throws RequestNotFoundException;

	public List<Employee> viewEmployee();

	public List<Employee> getAllEmployees();

	public int createEmployee(Employee e);

	public boolean updateEmployee(Employee change);

	boolean deleteEmployee(int employeeId);

	public void setEmployeeDao(EmployeeDAO employeeDao);

	public Employee register(Employee newEmployee) throws EmployeeAlreadyExistsException;

	public Employee getEmployeeById(int Id);




}