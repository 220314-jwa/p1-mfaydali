package dev.mfaydali.services;

import java.util.List;

import dev.mfaydali.models.Request;

public interface ReimbursementServices {

	public List<Request> getAllReimbursements();

	public boolean createTuitionReimbursementRequest(Request req);

	public Request getTuitionReimbursementRequest(int requestId);

	public boolean deleteReimbursement(int requestId);

	public static Request deleteRequest(Request toBeDeleted) {
		// TODO Auto-generated method stub
		return null;
	}

}
