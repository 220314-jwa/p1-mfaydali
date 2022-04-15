package dev.mfaydali.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import dev.mfaydali.data.EmployeeDAO;
import dev.mfaydali.data.RequestDAO;
import dev.mfaydali.models.Request;
public class ReimbursementServiceTest {
	@Mock // says that we want Mockito to create a mock version of this object
	private EmployeeDAO employeeDao;

	@Mock
	private RequestDAO requestDao;

	// we need a field for the class that we're testing
	@InjectMocks // this is where Mockito needs to inject the mocks
	private ReimbursementServices reimburseServ = new ReimbursementServiceImpl();

	// test methods always have no parameters and return void
	@Test
	public void exampleTest() {
		assertTrue(true);
	}

	@Test
	void deleteRequest() {
		int requestId = 1;
		boolean actual = reimburseServ.deleteReimbursement(requestId);
		Assertions.assertTrue(actual);
	}

	@Test
	public void getAll() {

		List<Request> temp=reimburseServ.getAllReimbursements();
		for (Request status : temp) {
			System.out.println(status.toString());
		}
	}

}
