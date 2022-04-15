package dev.mfaydali.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import dev.mfaydali.models.Status;

public class StatusDAOTest {

	private static StatusDAOImp statusDao = new StatusDAOImp();
	private static Status status = new Status();
	private StatusDAO statusDAO = DAOFactory.getStatusDAO();

	//	@Test
	//	public void create() {
	//		Status temp=statusDao.create(status);
	//		assertEquals("OK", temp.getStatusName());
	//		assertEquals(2, temp.getStatusId());
	//	}

	@Test
	public void delete() {
		boolean status = statusDao.deleteStatusMessage(1);
		assertEquals("Invalid ID", status);
	}

	//	@Test
	//	public void getId() {
	//		Status status = statusDao.getStatusMessage(1);
	//		assertNotEquals(1, status.getStatusId());
	//	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void getByStatusIdExists() {
		int id = status.getStatusId();
		Status status = statusDao.getById(id);
		equals(status);
	}

	@Test
	public void getByIdDoesNotExist() {
		Status status = statusDAO.getById(0);
		assertNull(status);
	}

}
