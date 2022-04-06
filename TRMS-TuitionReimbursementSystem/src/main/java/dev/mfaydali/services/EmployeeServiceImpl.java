package dev.mfaydali.services;

import dev.mfaydali.data.EmployeeDAO;
import dev.mfaydali.data.RequestDAO;
import dev.mfaydali.exceptions.EmployeeNotFoundException;
import dev.mfaydali.exceptions.RequestNotFoundException;
import dev.mfaydali.models.Employee;
import dev.mfaydali.models.Request;


public abstract class EmployeeServiceImpl implements EmployeeServices {
	private EmployeeDAO employeeDao;
	private RequestDAO reqDAO;

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
}