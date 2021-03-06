package dev.mfaydali.data;

import java.util.List;

import dev.mfaydali.models.Request;

public interface RequestDAO extends GenericDAO<Request>{


	public boolean createTuitionReimbursementRequest(Request req);

	public List<Request> getAllReimbursements();

	public Request getTuitionReimbursementRequest(int requestId);

	public Request getTuitionReimbursementRequestByTime(java.sql.Timestamp ts, int requestId);

	public boolean deleteReimbursement(int requestId);

}
