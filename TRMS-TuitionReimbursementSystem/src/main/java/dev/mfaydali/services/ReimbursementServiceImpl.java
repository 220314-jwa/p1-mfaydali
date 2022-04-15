package dev.mfaydali.services;

import java.util.List;

import dev.mfaydali.data.DAOFactory;
import dev.mfaydali.data.RequestDAO;
import dev.mfaydali.models.Request;

public class ReimbursementServiceImpl implements ReimbursementServices {
	private RequestDAO reqDAO = DAOFactory.getRequestDAO();


	@Override
	public List<Request> getAllReimbursements() {
		return reqDAO.getAllReimbursements();
	}

	@Override
	public boolean createTuitionReimbursementRequest(Request req) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Request getTuitionReimbursementRequest(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteReimbursement(int requestId) {
		return reqDAO.deleteReimbursement(requestId);
	}


}
