package controllers;

import dev.mfaydali.exceptions.EmployeeAlreadyExistsException;
import dev.mfaydali.models.Employee;
import dev.mfaydali.services.EmployeeServiceImpl;
import dev.mfaydali.services.EmployeeServices;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import io.javalin.http.UnauthorizedResponse;

public class EmployeeController {
	private static EmployeeServices employeeServ = new EmployeeServiceImpl();

	// POST to /users
	public static void registerUser(Context ctx) {
		Employee newEmployee = ctx.bodyAsClass(Employee.class);

		try {
			newEmployee = employeeServ.register(newEmployee);
			ctx.json(newEmployee);
		} catch (EmployeeAlreadyExistsException e) {
			ctx.status(HttpCode.CONFLICT); // 409 conflict
		}
	}

	public void logIn(Context ctx) {
		Employee body;
		try {
			body =ctx.bodyAsClass(Employee.class);
		}catch(Exception e) {
			throw new BadRequestResponse();
		}
		Employee employee = employeeServ.getEmployeeById(body.getEmployeeId());
		if (employee == null) {
			throw new UnauthorizedResponse();
		}

	}

	// POST to /auth
	//		public static void logIn(Context ctx) {
	//			Employee newEmployee = ctx.bodyAsClass(Employee.class);
	//			int employeeId();
	//
	//			try {
	//				Employee employee = employeeServ.loginEmployee();
	//				ctx.json(employee);
	//			} catch (EmployeeNotFoundException e) {
	//				ctx.status(HttpCode.UNAUTHORIZED); // 401 unauthorized
	//			}
	//		}

	// GET to /users/{id} where {id} is the user's id
	public static void getEmployeeById(Context ctx) {
		String pathParam = ctx.pathParam("id");
		if (pathParam != null && !pathParam.equals("undefined") && !pathParam.equals("null")) {
			int employeeId = Integer.parseInt(pathParam);

			Employee employee = employeeServ.getEmployeeById(employeeId);
			if (employee != null)
				ctx.json(employee);
			else
				ctx.status(HttpCode.NOT_FOUND); // 404 not found
		} else {
			ctx.status(HttpCode.BAD_REQUEST); // 400 bad request
		}
	}

}
