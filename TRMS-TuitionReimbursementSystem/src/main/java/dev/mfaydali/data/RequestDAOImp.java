package dev.mfaydali.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dev.mfaydali.models.Request;
import dev.mfaydali.utils.ConnectionFactory;

public class RequestDAOImp implements RequestDAO {
	// connection object, used to connect to the database:
	private static ConnectionFactory connFactory = ConnectionFactory.getConnectionFactory();

	@Override
	public boolean createTuitionReimbursementRequest(Request newReq) {

		Connection conn = connFactory.getConnection();

		String sql = "insert into reimbursement_request(request_id, submitter_id, event_type_id, status_id, event_date, cost, description, location, submitted_at)"
				+ "values(?,?,?,?,?,?,?,?,?)";

		try {
			// create a prepared statement, we pass in the sql command
			// also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
			PreparedStatement preparedStatement = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			// set the fields:
			preparedStatement.setInt(1, newReq.getRequestId());
			preparedStatement.setInt(2, newReq.getSubmitterId());
			preparedStatement.setInt(3, newReq.getEventId());
			preparedStatement.setInt(4, newReq.getStatusId());
			preparedStatement.setTimestamp(5, (Timestamp) newReq.getEventDate());
			preparedStatement.setInt(6, newReq.getCost());
			preparedStatement.setString(7, newReq.getDescription());
			preparedStatement.setString(8, newReq.getLocation());
			preparedStatement.setTimestamp(9, (Timestamp) newReq.getSubmittedAt());

			// // shortcut for now, but we need the corresponding id for the status
			// int status_id;
			// if (newDept.getStatus().equals("available")) {
			// status_id = 1;
			// }
			// else {
			// status_id = 2;
			// }
			// preparedStatement.setInt(5, status_id);

			// execute this command, return number of rows affected:
			int count = preparedStatement.executeUpdate();
			// lets us return the id that is auto-generated
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			// if we affected one or more rows:
			if (count > 0) {
				System.out.println("Request added!");
				// return the generated id:
				// before we call resultSet.next(), it's basically pointing to nothing useful
				// but moving that pointer allows us to get the information that we want
				resultSet.next();
				boolean requestId = resultSet.getBoolean(1);
				return requestId;
			}
			// if 0 rows are affected, something went wrong:
			else {
				System.out.println("Something went wrong when trying to add department!");
				return false;
			}
		} catch (SQLException e) {
			// print out what went wrong:
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Request getTuitionReimbursementRequest(int requestId) {
		try {
			Connection conn = connFactory.getConnection();
			String sql = "SELECT * FROM request_reimbursement WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, Integer.toString(requestId));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Request req = new Request(requestId);
				req.setRequestId(rs.getInt("request_id"));
				req.setSubmitterId(rs.getInt("submitter_id"));
				req.setEventId(rs.getInt("event__type_id"));
				req.setStatusId(rs.getInt("status_id"));
				req.setEventDate(rs.getTimestamp("event_date"));
				req.setCost(rs.getInt("cost"));
				req.setDescription(rs.getString("description"));
				req.setDescription(rs.getString("location"));
				req.setSubmittedAt(rs.getTimestamp("submitted_at"));
				return req;
			}
			return new Request(0);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public Request getTuitionReimbursementRequestByTime(java.sql.Timestamp ts, int requestId) {
		try {
			Connection conn = connFactory.getConnection();
			String sql = "SELECT * FROM Request WHERE requestId = ? + submittedAt=?";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, Integer.toString(requestId));
			ps.setTimestamp(2, ts);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Request req = new Request(requestId);
				req.setRequestId(rs.getInt("request_id"));
				req.setSubmitterId(rs.getInt("submitter_id"));
				req.setEventId(rs.getInt("event_id"));
				req.setStatusId(rs.getInt("status_id"));
				req.setEventDate(rs.getTimestamp("event_date"));
				req.setCost(rs.getInt("cost"));
				req.setDescription(rs.getString("description"));
				req.setLocation(rs.getString("location"));
				req.setSubmittedAt(rs.getTimestamp("submitted_at"));
				return req;
			}
			return new Request(0);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public int create(Request newObj){
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Request getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Request updatedObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Request objToDelete) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteReimbursement(int requestId) {
		Connection conn = connFactory.getConnection();
		String sql = "delete from reimbursement_request where request_id = ?;";
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, requestId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Request> getAllReimbursements() {
		List<Request> request = new ArrayList<Request>();
		try {
			Connection conn = connFactory.getConnection();
			String sql = "SELECT * FROM reimbursement_request";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Request r = new Request(0);
				r.setRequestId(rs.getInt("request_id"));
				r.setSubmitterId(rs.getInt("submitter_id"));
				r.setEventId(rs.getInt("eventId"));
				r.setStatusId(rs.getInt("statusId"));
				r.setEventDate(rs.getTimestamp("event_date"));
				r.setCost(rs.getInt("cost"));
				r.setDescription(rs.getString("description"));
				r.setLocation(rs.getString("location"));
				r.setSubmittedAt(rs.getTimestamp("submitted_at"));
				request.add(r);
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return request;
	}

	@Override
	public List<Request> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
