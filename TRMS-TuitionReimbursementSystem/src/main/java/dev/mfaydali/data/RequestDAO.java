package dev.mfaydali.data;

import dev.mfaydali.models.Request;

public interface RequestDAO extends GenericDAO<Request>{


	public boolean createTuitionReimbursementRequest(Request req);

	public Request getTuitionReimbursementRequest(int requestId);

	public Request getTuitionReimbursementRequest(java.sql.Timestamp ts, int requestId);

}
