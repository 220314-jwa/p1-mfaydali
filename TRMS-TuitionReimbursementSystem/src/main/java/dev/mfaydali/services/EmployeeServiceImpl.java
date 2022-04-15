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
	public Employee loginEmployee(String username, String password) throws EmployeeNotFoundException{
		Employee employee = employeeDao.getByUserName(username);
		if (employee != null && employee.getPassword().equals(password)) {
			return employee;
		} else {
			throw new EmployeeNotFoundException();
		}
	}

	//	@Override
	//	public Employee logIn(String username, String password) throws IncorrectCredentialsException {
	//		Employee employeeFromDatabase = employeeDao.getByUsername(username);
	//		if (employeeFromDatabase != null && employeeFromDatabase.getPassword().equals(password)) {
	//			return employeeFromDatabase;
	//		} else {
	//			throw new IncorrectCredentialsException();
	//		}
	//	}



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





	//	@Override
	//	public Employee updateEmployee(Employee change) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}



	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeDao.getById(employeeId);
	}


	@Override
	public Employee registerEmployee(Employee newEmployee) throws EmployeeAlreadyExistsException {
		int employeeId = employeeDao.create(newEmployee);
		if (employeeId != 0) {
			newEmployee.setEmployeeId(employeeId);
			return newEmployee;
		} else {
			throw new EmployeeAlreadyExistsException();
		}
	}

}