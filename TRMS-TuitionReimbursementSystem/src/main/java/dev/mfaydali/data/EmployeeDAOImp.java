package dev.mfaydali.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.mfaydali.models.Employee;
import dev.mfaydali.utils.ConnectionFactory;

public class EmployeeDAOImp implements EmployeeDAO {

	Connection connection;

	// constructor, retrieve/get a connection from the connection factory
	public EmployeeDAOImp() {
		// calling the method that we made in ConnectionFactory:
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public int createEmployee(Employee e) {
		// this stores our sql command, that we would normally to DBeaver/command line
		// 0 1 2 3 4 5
		String sql = "INSERT INTO Employee (employeeId, managerId, deptId, firstName, lastname)"
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			// create a prepared statement, we pass in the sql command
			// also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated

			PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setInt(1, e.getEmployeeId());
			ps.setInt(2, e.getManagerId());
			ps.setInt(3, e.getDeptId());
			ps.setString(4, e.getfName());
			ps.setString(5, e.getLname());
			return 1;

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return -1;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		try {
			String sql = "SELECT * FROM employees WHERE employeeId = ?";
			PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt("Employee_ID"));
				e.setManagerId(rs.getInt("Manager_ID"));
				e.setDeptId(rs.getInt("Department_ID"));
				e.setfName(rs.getString("First_Name"));
				e.setLname(rs.getString("Last_Name"));

				return e;
			}
			return new Employee();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			String sql = "SELECT * FROM employees";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt("Employee_ID"));
				e.setManagerId(rs.getInt("Manager_ID"));
				e.setDeptId(rs.getInt("Department_ID"));
				e.setfName(rs.getString("First_Name"));
				e.setLname(rs.getString("Last_Name"));
				employees.add(e);
			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return employees;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		try {
			String sql = "UPDATE employees SET " + "			employeeId = ?, managerId = ?, deptId = ?, "
					+ "			firstName = ?, lastname = ?, WHERE employeeId = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, e.getEmployeeId());
			ps.setInt(2, e.getManagerId());
			ps.setInt(3, e.getDeptId());
			ps.setString(4, e.getfName());
			ps.setString(5, e.getLname());
			return true;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		try {
			String sql = "DELETE FROM employees WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ps.executeQuery();
			return true;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public int create(Employee newObj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee updatedObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Employee objToDelete) {
		// TODO Auto-generated method stub

	}

}
