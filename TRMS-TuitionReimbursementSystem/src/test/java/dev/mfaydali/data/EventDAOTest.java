package dev.mfaydali.data;

import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

import dev.mfaydali.models.Event;

@TestMethodOrder(OrderAnnotation.class)

public class EventDAOTest {
	private static EventDAO eventDao = DAOFactory.getEventDAO();
	private static Event testEvent = new Event();
	private static Event testNewEvent = new Event();

	@BeforeAll
	public static void setUp() {

		testEvent.setEventName("test");


		Random rand = new Random();
		testNewEvent.setEventName("test_" + rand.nextLong());


		try {
			testEvent.setEventId(eventDao.create(testEvent));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterAll
	public static void cleanUp() {
		// TODO remove users in DB with username containing "test"
		eventDao.delete(testEvent);
	}


}
