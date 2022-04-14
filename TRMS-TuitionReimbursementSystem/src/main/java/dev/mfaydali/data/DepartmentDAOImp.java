package dev.mfaydali.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.mfaydali.models.Department;
import dev.mfaydali.utils.ConnectionFactory;

public class DepartmentDAOImp implements DepartmentDAO {

	// connection object, used to connect to the database:
	Connection connection;

	// constructor, retrieve/get a connection from the connection factory
	public DepartmentDAOImp() {
		// calling the method that we made in ConnectionFactory:
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public int create (Department newDept) {
		String sql = "insert into department(dept_id, dept_head_id, dept_name)" +
				"values(default,?,?)";

		try {
			// create a prepared statement, we pass in the sql command
			// also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated
			PreparedStatement preparedStatement = connection.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			// set the fields:
			preparedStatement.setInt(1, newDept.getDeptId());
			preparedStatement.setInt(2, newDept.getDeptHeadId());
			preparedStatement.setString(2, newDept.getDeptName());


			//            // shortcut for now, but we need the corresponding id for the status
			//            int status_id;
			//            if (newDept.getStatus().equals("available")) {
			//                status_id = 1;
			//            }
			//            else {
			//                status_id = 2;
			//            }
			//            preparedStatement.setInt(5, status_id);

			// execute this command, return number of rows affected:
			int count = preparedStatement.executeUpdate();
			// lets us return the id that is auto-generated
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			// if we affected one or more rows:
			if (count > 0) {
				System.out.println("Department added!");
				// return the generated id:
				// before we call resultSet.next(), it's basically pointing to nothing useful
				// but moving that pointer allows us to get the information that we want
				resultSet.next();
				int deptId = resultSet.getInt(1);
				return deptId;
			}
			// if 0 rows are affected, something went wrong:
			else {
				System.out.println("Something went wrong when trying to add department!");
				return -1;
			}
		} catch (SQLException e){
			// print out what went wrong:
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> department = new ArrayList<Department>();
		try {
			String sql = "SELECT * FROM department";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department d = new Department();
				d.setDeptId(rs.getInt("department_id"));
				d.setDeptHeadId(rs.getInt("dept_head_id"));
				d.setDeptName(rs.getString("dept_name"));
				department.add(d);
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return department;
	}

	@Override
	public Department getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Department updatedObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Department objToDelete) {
		// TODO Auto-generated method stub

	}
}
