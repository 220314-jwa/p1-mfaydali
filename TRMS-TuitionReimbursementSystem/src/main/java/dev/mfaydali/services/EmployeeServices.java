package dev.mfaydali.services;

import java.util.List;

import dev.mfaydali.exceptions.EmployeeNotFoundException;
import dev.mfaydali.exceptions.RequestNotFoundException;
import dev.mfaydali.models.Employee;
import dev.mfaydali.models.Request;


public interface EmployeeServices {

	public Employee loginEmployee(int employeeId) throws EmployeeNotFoundException;

	public Request request(int requestId) throws RequestNotFoundException;

	public List<Employee> viewEmployee();


}