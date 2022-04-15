package dev.mfaydali.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.mfaydali.data.EmployeeDAO;
import dev.mfaydali.data.RequestDAO;
import dev.mfaydali.exceptions.EmployeeNotFoundException;
import dev.mfaydali.models.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	@Mock // says that we want Mockito to create a mock version of this object
	private EmployeeDAO employeeDao;

	@Mock
	private RequestDAO requestDao;

	// we need a field for the class that we're testing
	@InjectMocks // this is where Mockito needs to inject the mocks
	private EmployeeServices employeeServ = new EmployeeServiceImpl();

	// test methods always have no parameters and return void
	@Test
	public void exampleTest() {
		assertTrue(true);
	}

	@Test
	public void logInSuccessfully() throws EmployeeNotFoundException {
		// setup (arguments, expected result, etc.)
		String username = "mfaydali";
		String password = "password";

		// mocking: we need to mock userDao.getByUsername(username)
		// we're expecting a user with matching username & password
		Employee mockUser = new Employee();
		mockUser.setUsername(username);
		mockUser.setPassword(password);
		when(employeeDao.getByUserName(username)).thenReturn(mockUser);

		// call the method we're testing
		Employee result = employeeServ.loginEmployee(username, password);

		// assertion
		assertEquals(username, result.getUsername());
	}



	@Test
	public void updateEmployeeSuccessfully() {
		Employee test = new Employee();
		test.setEmployeeId(1);
		test.setManagerId(10);
		test.setDeptId(100);
		test.setFirstName("Revature");
		test.setLastName("Java");
		test.setUsername("username");
		test.setPassword("password");

		EmployeeDAO employeeDao = mock(EmployeeDAO.class);
		employeeServ.setEmployeeDao(employeeDao);

		assertTrue(employeeServ.updateEmployee(test));
	}

	@Test
	void deleteEmployee() {
		int employeeId = 1;
		boolean actual = employeeServ.deleteEmployee(employeeId);
		Assertions.assertFalse(actual);
	}

}
