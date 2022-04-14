package dev.mfaydali.services;

import java.util.List;

import dev.mfaydali.data.DAOFactory;
import dev.mfaydali.data.EmployeeDAO;
import dev.mfaydali.data.RequestDAO;
import dev.mfaydali.exceptions.EmployeeAlreadyExistsException;
import dev.mfaydali.exceptions.EmployeeNotFoundException;
import dev.mfaydali.exceptions.RequestNotFoundException;
import dev.mfaydali.models.Employee;
import dev.mfaydali.models.Request;

public class EmployeeServiceImpl implements EmployeeServices {
	private EmployeeDAO employeeDao = DAOFactory.getEmployeeDAO();
	private RequestDAO reqDAO = DAOFactory.getRequestDAO();

	@Override
	public Employee loginEmployee(int employeeId) throws EmployeeNotFoundException {
		Employee employee = employeeDao.getEmployee(employeeId);
		if (employee.getEmployeeId() == 0) {
			throw new EmployeeNotFoundException("The employee id entered does not exist in the database");
		} else {
			return employee;
		}
	}


	@Override
	public Request request(int requestId) throws RequestNotFoundException {
		Request req = reqDAO.getTuitionReimbursementRequest(requestId);
		if (req.getRequestId() == 0) {
			throw new RequestNotFoundException("The employee id entered does not exist in the database");
		} else {
			return req;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {
			employeeDao.updateEmployee(employee);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> viewEmployee() {
		// TODO Auto-generated method stub
		return null;
	}



	//	@Override
	//	public Employee updateEmployee(Employee change) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

	@Override
	public int createEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee register(Employee newEmployee) throws EmployeeAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Employee getEmployeeById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}