package dev.mfaydali.data;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dev.mfaydali.models.Employee;

@TestMethodOrder(OrderAnnotation.class)
public class EmployeeDAOTest {
	private static EmployeeDAO employeeDao = DAOFactory.getEmployeeDAO();
	private static Employee testEmployee = new Employee();
	private static Employee testNewEmployee = new Employee();

	@BeforeAll
	public static void setUp() {
		// this is the base test user used for most tests
		testEmployee.setfName("test");

		// this is the user to test create and delete
		Random rand = new Random();
		testNewEmployee.setfName("test_" + rand.nextLong());

		// TODO create user in DB with username "test"
		// and set the user's ID to the returned value
		testEmployee.setEmployeeId(employeeDao.createEmployee(testEmployee));
	}

	@AfterAll
	public static void cleanUp() {
		// TODO remove users in DB with username containing "test"
		employeeDao.delete(testEmployee);
	}


	@Test
	@Order(1)
	public void createUserSuccessfully() {
		int employeeId = employeeDao.createEmployee(testNewEmployee);

		assertNotEquals(0, employeeId);
	}

	@Test
	public void getByIdExists() {
		int employeeId = testEmployee.getEmployeeId();

		Employee employee = employeeDao.getById(employeeId);

		assertEquals(testEmployee, employee);
	}

	@Test
	public void getByIdDoesNotExist() {
		Employee employee = employeeDao.getById(0);
		assertNull(employee);
	}

	@Test
	public void getAll() {
		assertNotNull(employeeDao.getAll());
	}

	@Test
	public void updateUserExists() {
		assertDoesNotThrow(() -> {
			employeeDao.update(testEmployee);
		});
	}

	@Test
	public void updateUserDoesNotExist() {
		assertThrows(SQLException.class, () -> {
			employeeDao.update(new Employee());
		});
	}

	@Test
	@Order(2)
	public void deleteUserExists() {
		assertDoesNotThrow(() -> {
			employeeDao.delete(testNewEmployee);
		});
	}

	@Test
	public void deleteUserDoesNotExist() {
		assertThrows(SQLException.class, () -> {
			employeeDao.delete(new Employee());
		});
	}
}
