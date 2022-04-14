package dev.mfaydali.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
		int employeeId=12345;

		// mocking: we need to mock userDao.getByUsername(username)
		// we're expecting a user with matching username & password
		Employee mockEmployee = new Employee();
		mockEmployee.setEmployeeId(employeeId);
		when(employeeDao.getEmployee(employeeId)).thenReturn(mockEmployee);

		// call the method we're testing
		Employee result = employeeServ.loginEmployee(employeeId);

		// assertion
		assertEquals(employeeId, result.getEmployeeId());
	}

	@Test
	public void logInWrongEmployeeId() {
		int employeeId=1960;

		// we need to mock userDao.getByUsername(username)
		when(employeeDao.getEmployee(employeeId)).thenReturn(null);

		assertThrows(EmployeeNotFoundException.class, () -> {
			// put the code that we're expecting to throw the exception
			employeeServ.loginEmployee(employeeId);
		});
	}

	@Test
	public void updateEmployeeSuccessfully() {
		Employee test = new Employee();
		test.setEmployeeId(1);
		test.setManagerId(10);
		test.setDeptId(100);
		test.setfName("Revature");
		test.setLname("Java");

		EmployeeDAO employeeDao = mock(EmployeeDAO.class);
		employeeServ.setEmployeeDao(employeeDao);

		assertTrue("Update employee should return true", employeeServ.updateEmployee(test));
	}

	@Test
	void deleteEmployee() {
		int employeeId = 1;
		boolean actual = employeeServ.deleteEmployee(employeeId);
		Assertions.assertFalse(actual);
	}

}
//	@Test
//	void getAllEmployees() {
//		List<Employee> mocklist = new ArrayList<Employee>();
//
//		Mockito.when(employeeDao.getAllEmployees()).thenReturn(mocklist);
//		List<Employee> actual = employeeServ.loginEmployee();
//		Assertions.assertNotNull(actual);
//
//	}
//	@Test
//	void getAllUserLoginsbyeid() {
//		List<UserLogin> mocklist = new ArrayList<UserLogin>();
//		int eid = 1;
//		Mockito.when(udao.getAllUserLogins(eid)).thenReturn(mocklist);
//		List<UserLogin> actual = us.getAllUserLogins(eid);
//		Assertions.assertNotNull(actual);
//
//	}

//
//
//	@Test
//	@Disabled
//	public void registerSuccessfully() throws UsernameAlreadyExistsException {
//		User newUser = new User();
//
//		User result = userServ.register(newUser);
//
//		// the behavior that i'm looking for is that the
//		// method returns the User with their newly generated ID,
//		// so i want to make sure the ID was generated (not the default)
//		assertNotEquals(0, result.getId());
//	}
//
//	@Test
//	@Disabled
//	public void registerUsernameTaken() {
//		User newUser = new User();
//		newUser.setUsername("snicholes");
//
//		assertThrows(UsernameAlreadyExistsException.class, () -> {
//			userServ.register(newUser);
//		});
//	}
//
//	@Test
//	@Disabled
//	public void viewPetsSuccessfully() {
//		List<Pet> pets = userServ.viewAvailablePets();
//
//		// i just want to make sure that the pets are returned -
//		// i don't need to check that the pets are all available
//		// because that filtering happens in the database. i just
//		// need to check that the pets list isn't null
//		assertNotNull(pets);
//	}
//
//	@Test
//	@Disabled
//	public void searchPetsBySpecies() {
//		String species = "cat";
//		List<Pet> petsBySpecies = userServ.searchPetsBySpecies(species);
//
//		boolean onlyCatsInList = true;
//		for (Pet pet : petsBySpecies) {
//			String petSpecies = pet.getSpecies().toLowerCase();
//			// if the pet species doesn't contain the species passed in
//			if (!petSpecies.contains(species)) {
//				// then we'll set the boolean to false
//				onlyCatsInList = false;
//				// and stop the loop because we don't need to continue
//				break;
//			}
//		}
//
//		assertTrue(onlyCatsInList);
//	}
//
//	@Test
//	public void adoptPetSuccessfully() throws Exception {
//		User testUser = new User();
//		Pet testPet = new Pet();
//
//		// petDao.getById: return testPet
//		when(petDao.getById(testPet.getId())).thenReturn(testPet);
//		// userDao.getById: return testUser
//		when(userDao.getById(testUser.getId())).thenReturn(testUser);
//		// petDao.update: do nothing
//		// when petDao update is called with any pet object, do nothing
//		doNothing().when(petDao).update(any(Pet.class));
//		// userDao.update: do nothing
//		doNothing().when(userDao).update(any(User.class));
//		// userDao.updatePets: do nothing
//		doNothing().when(userDao).updatePets(testPet.getId(), testUser.getId());
//
//		User result = userServ.adoptPet(testUser, testPet);
//
//		// there are two behaviors i'm looking for:
//		// that the user now has the pet in their list of pets,
//		// and that the pet in the list has its status updated.
//		// to check this, i'm checking that the pet with the Adopted
//		// status is in the user's list.
//		testPet.setStatus("Adopted");
//		List<Pet> usersPets = result.getPets();
//		assertTrue(usersPets.contains(testPet));
//
//		// Mockito.verify allows you to make sure that a particular mock method
//		// was called (or that it was never called, or how many times, etc.)
//		verify(petDao, times(1)).update(any(Pet.class));
//	}
//
//	@Test
//	public void adoptPetAlreadyAdopted() throws SQLException {
//		User testUser = new User();
//		Pet testPet = new Pet();
//		testPet.setStatus("Adopted");
//
//		// petDao.getById: return testPet
//		when(petDao.getById(testPet.getId())).thenReturn(testPet);
//
//		assertThrows(Exception.class, () -> {
//			userServ.adoptPet(testUser, testPet);
//		});
//
//		verify(petDao, never()).update(any(Pet.class));
//		verify(userDao, never()).update(any(User.class));
//		verify(userDao, never()).updatePets(testPet.getId(), testUser.getId());
//	}
//

