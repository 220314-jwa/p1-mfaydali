package dev.mfaydali.data;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import dev.mfaydali.models.Request;

public class RequestDAOTest {

	private static RequestDAO requestDao = DAOFactory.getRequestDAO();
	private static Request testRequest = new Request();
	private static Request testNewRequest = new Request();

	private static int requestId;
	private static int submitterId = 1;
	private static int eventId;
	private static int statusId;
	private static Date eventDate;
	private static int cost = 1;
	private static String description = "test_description";
	private static String location = "test_location";
	private static Date submittedAt;


	@BeforeAll
	public static void init(){
		//Make sure table to created.
		//Create mock data for login
		testRequest = new Request(requestId);
		testRequest.setRequestId(requestId);
		testRequest.setSubmitterId(submitterId);
		testRequest.setEventId(eventId);
		testRequest.setStatusId(statusId);
		testRequest.setEventDate(eventDate);
		testRequest.setCost(cost);
		testRequest.setDescription(description);
		testRequest.setLocation(location);
		testRequest.setSubmittedAt(submittedAt);
		//Mock user session
		//Mock user request
	}

	//one test for each CRUD functions
	@Test
	@Order(1)
	void createRequest() throws Exception {
		System.out.println("Create Request:");
		int requestId = requestDao.create(testNewRequest);
		testNewRequest.setRequestId(requestId);

		assertNotEquals(0, requestId);
	}
	@Test
	@Order(2)
	void getRequestById() {
		System.out.println("Get Request by ID:");
		int requestId = testRequest.getRequestId();

		Request request = requestDao.getById(requestId);
		assertEquals(testRequest, request);
	}
	@Test
	@Order(3)
	void getAllRequests() {
		System.out.println("Get All Requests:");
		List<Request> requests = requestDao.getAllReimbursements();
		assertNotEquals(null, requests);
	}


}
 */