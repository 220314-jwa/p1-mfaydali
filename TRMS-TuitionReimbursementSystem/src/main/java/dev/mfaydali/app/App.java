package dev.mfaydali.app;

import dev.mfaydali.data.DAOFactory;
import dev.mfaydali.data.EmployeeDAO;
import dev.mfaydali.models.Employee;
import dev.mfaydali.services.EmployeeServices;
import io.javalin.Javalin;

public class App {
	private static EmployeeServices employeeServ;

	public static void main(String[] args) {

		Javalin app = Javalin.create();
		app.start(8080);
		// just to test, creating a pet:
		// post method, takes in a lambda function
		/*
		 * We can test this out in postman by making a post request with this url:
		 * http://localhost:8080/pets and pass in the pet object in the body Postman ->
		 * Javalin -> DAO -> Database
		 */

		app.get("/employees", ctx -> {
			// .json() is an alternative to .result() that
			// sets the data type as JSON, the format that we
			// will be sending/receiving data in!
			//ctx.json(employeeServ.viewEmployee());
			ctx.result("it works");
		});

		app.post("/adduser", ctx -> {
			// because this a function, we actually write code in here:
			// create a Pet object, we get this data from the body of the HTTP request
			Employee user= ctx.bodyAsClass(dev.mfaydali.models.Employee.class);
			// get out pet dao from the dao factory:
			EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();

			employeeDAO.create(user);
		});

		app.post("/employees", ctx -> {
			// because this a function, we actually write code in here:
			// create a Pet object, we get this data from the body of the HTTP request
			Employee employee= ctx.bodyAsClass(dev.mfaydali.models.Employee.class);
			// get out pet dao from the dao factory:
			EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
			// try to insert pet object into database
			int employeeId = employeeDAO.create(employee);
			// return the id back to the user:
			ctx.result("The employee id is: " + employeeId);
		});


	}

}
