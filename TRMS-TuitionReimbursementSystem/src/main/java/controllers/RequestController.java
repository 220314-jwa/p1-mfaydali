package controllers;



import org.asynchttpclient.Request;

import dev.mfaydali.services.ReimbursementServiceImpl;
import dev.mfaydali.services.ReimbursementServices;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class RequestController {
	private static ReimbursementServices reimbursementServ = new ReimbursementServiceImpl();

	// GET to /pets
	public static void getRequests(Context ctx) {
		ctx.json(reimbursementServ.getAllReimbursements());
	}

	// GET to /pets/{id} where {id} is the ID of the pet
	public static void getRequestById(Context ctx) {
		int requestId = Integer.parseInt(ctx.pathParam("id"));
		Request request = (Request) reimbursementServ.getTuitionReimbursementRequest(requestId);
		if (request != null)
			ctx.json(request);
		else
			ctx.status(HttpCode.NOT_FOUND); // 404 not found
	}


}


