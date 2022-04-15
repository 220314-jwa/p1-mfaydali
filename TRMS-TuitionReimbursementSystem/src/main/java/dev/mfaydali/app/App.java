package dev.mfaydali.app;

import java.util.Map;

import dev.mfaydali.data.DAOFactory;
import dev.mfaydali.data.EmployeeDAO;
import dev.mfaydali.models.Employee;
import dev.mfaydali.services.EmployeeServiceImpl;
import dev.mfaydali.services.EmployeeServices;
import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class App {
	private static EmployeeServices employeeServ = new EmployeeServiceImpl();

	public static void main(String[] args) {

		Javalin app = Javalin.create();
		app.start(7777);

		//		app.routes(() -> {
		//
		//			path("requests", () -> {
		//				get(RequestController::getRequests);
		//
		//				path("{id}", () -> {
		//					get(RequestController::getRequestById);
		//
		//				});
		//			});
		//
		//			path("employees", () -> {
		//				post(EmployeeController::registerEmployee);
		//				path("{id}", () -> {
		//					get(EmployeeController::getEmployeeById);
		//				});
		//			});
		//			// all paths starting with /auth
		//			path("auth", () -> {
		//				post(EmployeeController::logIn);
		//			});
		//
		//		});

		// POST to /auth: log in
		//		app.post("/auth", ctx -> {
		//			// if the keys in JSON data don't exactly match a class,
		//			// we can just use a Map!
		//			Map<String,String> credentials = ctx.bodyAsClass(Map.class);
		//			String username = credentials.get("username");
		//			String password = credentials.get("password");
		//
		//			try {
		//				Employee employee = employeeServ.loginEmployee(username, password);
		//				ctx.json(employee);
		//			} catch (EmployeeNotFoundException e) {
		//				ctx.status(HttpCode.UNAUTHORIZED); // 401 unauthorized
		//			}
		//		});


		app.get("/employees", ctx -> {
			// .json() is an alternative to .result() that
			// sets the data type as JSON, the format that we
			// will be sending/receiving data in!
			// ctx.json(employeeServ.viewEmployee());
			ctx.result("it works");
		});

		app.post("/login", ctx -> {
			Map<String, String> credentials = ctx.bodyAsClass(Map.class);
			String username = credentials.get("username");
			System.out.println(username);
			String password = credentials.get("password");
			System.out.println(password);

			Employee employee = employeeServ.loginEmployee(username, password);

			if (employee != null) {
				ctx.json(employee);
			} else {
				ctx.status(HttpCode.UNAUTHORIZED);
			}
		});


		app.post("/adduser", ctx -> {
			// because this a function, we actually write code in here:
			// create a Pet object, we get this data from the body of the HTTP request
			Employee employee = ctx.bodyAsClass(dev.mfaydali.models.Employee.class);
			// get out pet dao from the dao factory:
			EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();

			employeeDAO.create(employee);
		});

		app.post("/employees", ctx -> {
			// because this a function, we actually write code in here:
			// create a Pet object, we get this data from the body of the HTTP request
			Employee employee = ctx.bodyAsClass(dev.mfaydali.models.Employee.class);
			// get out pet dao from the dao factory:
			EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
			// try to insert pet object into database
			int employeeId = employeeDAO.create(employee);
			// return the id back to the user:
			ctx.result("The employee id is: " + employeeId);
		});

	}
}
