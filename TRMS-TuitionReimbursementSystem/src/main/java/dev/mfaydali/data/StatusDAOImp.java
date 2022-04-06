package dev.mfaydali.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.mfaydali.models.Status;
import dev.mfaydali.utils.ConnectionFactory;

public class StatusDAOImp implements StatusDAO {
	// connection object, used to connect to the database:
	Connection connection;

	// constructor, retrieve/get a connection from the connection factory
	public StatusDAOImp() {
		// calling the method that we made in ConnectionFactory:
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public boolean createStatusMessage(Status stat) {

		String sql = "insert into Status(statusId, statusName)" + "values(?,?)";

		try {
			// create a prepared statement, we pass in the sql command
			// also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
			PreparedStatement preparedStatement = connection.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			// set the fields:
			preparedStatement.setString(1, Integer.toString(stat.getStatusId()));
			preparedStatement.setString(2, stat.getStatusName());

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
				System.out.println("Status added!");
				// return the generated id:
				// before we call resultSet.next(), it's basically pointing to nothing useful
				// but moving that pointer allows us to get the information that we want
				resultSet.next();
				boolean statusId = resultSet.getBoolean(0);
				return statusId;
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
	public Status getStatusMessage(int statusId) {
		try {
			String sql = "SELECT * FROM Status WHERE statusId = ?";
			PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, Long.toString(statusId));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Status stat = new Status(statusId, sql);
				stat.setStatusId(rs.getInt("Status_Id"));
				stat.setStatusName(rs.getString("Status_Name"));
				return stat;
			}
			return new Status(statusId, sql);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteStatusMessage(int statusId) {
		try {
			String sql = "DELETE FROM Status WHERE statusId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, statusId);
			ps.executeQuery();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int create(Status newObj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Status getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Status> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Status updatedObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Status objToDelete) {
		// TODO Auto-generated method stub

	}

}
