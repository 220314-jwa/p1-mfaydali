package dev.mfaydali.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dev.mfaydali.models.Department;

@TestMethodOrder(OrderAnnotation.class)

public class DepartmentDAOTest {
	private static DepartmentDAO departmentDao = DAOFactory.getDepartmentDAO();
	private static Department testDepartment = new Department();
	private static Department testNewDepartment = new Department();

	@BeforeAll
	public static void setUp() {
		// this is the base test pet used for most tests
		testDepartment.setDeptName("test");

		// this is the pet to test create and delete
		Random rand = new Random();
		testNewDepartment.setDeptName("test_" + rand.nextLong());

		// TODO create pet in DB with name "test"
		// and set the pet's ID to the returned value
		testDepartment.setDeptId(departmentDao.create(testDepartment));
	}


	@Test
	public void getAllDepartments() {

		assertNotNull(departmentDao.getAll());
	}

}
