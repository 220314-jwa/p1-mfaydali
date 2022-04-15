package dev.mfaydali.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.mfaydali.models.Event;
import dev.mfaydali.utils.ConnectionFactory;

public class EventDAOImp implements EventDAO {

	// connection object, used to connect to the database:

	private static ConnectionFactory connFactory = ConnectionFactory.getConnectionFactory();

	@Override
	public boolean createEvent(Event newEvent) {

		Connection conn = connFactory.getConnection();

		String sql = "insert into event_type(event_type_id, event_type_name)" + "values(?,?)";

		try {
			// create a prepared statement, we pass in the sql command
			// also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
			PreparedStatement preparedStatement = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			// set the fields:
			preparedStatement.setInt(1, newEvent.getEventId());
			preparedStatement.setString(2, newEvent.getEventName());

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
				System.out.println("Event added!");
				// return the generated id:
				// before we call resultSet.next(), it's basically pointing to nothing useful
				// but moving that pointer allows us to get the information that we want
				resultSet.next();
				boolean eventId = resultSet.getBoolean(1);
				return eventId;
			}
			// if 0 rows are affected, something went wrong:
			else {
				System.out.println("Something went wrong when trying to add event!");
				return false;
			}
		} catch (SQLException e) {
			// print out what went wrong:
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateEvent(Event newEvent) {
		Connection conn = connFactory.getConnection();
		String sql = "UPDATE event_type SET " + " event_type_id = ?, event_name= ? " + "	WHERE event_type_id = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newEvent.getEventId());
			ps.setString(2, newEvent.getEventName());
			return true;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEvent(int eventId) {
		Connection conn = connFactory.getConnection();

		try {
			String sql = "DELETE FROM event_type WHERE event_type_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eventId);
			ps.executeQuery();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int create(Event newObj){
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Event getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Event updatedObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Event objToDelete) {
		// TODO Auto-generated method stub

	}

}
