package dev.mfaydali.data;

// this class is responsible for instantiating/returning dao
public class DAOFactory {
	// initialize our pet dao to be null
	// keep static instances of our DAOs
	// save memory, etc.
	private static EmployeeDAO employeeDAO = null;
	private static DepartmentDAO departmentDAO = null;
	private static EventDAO eventDAO = null;
	private static RequestDAO requestDAO = null;
	private static StatusDAO statusDAO = null;

	// make our constructor private, so it can't be accessed publicly
	private DAOFactory() {

	}

	public static EmployeeDAO getEmployeeDAO() {
		// make sure we're not recreating the dao if it already exists:
		if (employeeDAO == null) {
			employeeDAO = new EmployeeDAOImp();
		}
		return employeeDAO;
	}

	public static DepartmentDAO getDepartmentDAO() {
		// make sure we're not recreating the dao if it already exists:
		if (departmentDAO == null) {
			departmentDAO = new DepartmentDAOImp();
		}
		return departmentDAO;
	}

	public static EventDAO getEventDAO() {
		// make sure we're not recreating the dao if it already exists:
		if (eventDAO == null) {
			eventDAO = new EventDAOImp();
		}
		return eventDAO;
	}

	public static RequestDAO getRequestDAO() {
		// make sure we're not recreating the dao if it already exists:
		if (requestDAO == null) {
			requestDAO = new RequestDAOImp();
		}
		return requestDAO;
	}

	public static StatusDAO getStatusDAO() {
		// make sure we're not recreating the dao if it already exists:
		if (statusDAO == null) {
			statusDAO = new StatusDAOImp();
		}
		return statusDAO;
	}


}
