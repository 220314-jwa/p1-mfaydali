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

	private static ConnectionFactory connFactory = ConnectionFactory.getConnectionFactory();

	@Override
	public int createEmployee(Employee e) {
		Connection conn = connFactory.getConnection();
		// this stores our sql command, that we would normally to DBeaver/command line
		// 0 1 2 3 4 5
		String sql = "INSERT INTO employees (employee_id, manager_id, dept_id, firstName, lastName, username, password)"
				+ "VALUES (?, ?, ?, ?, ?, ?,?)";
		try {
			// create a prepared statement, we pass in the sql command
			// also the flag "RETURN_GENERATED_KEYS" so we can get that id that is generated

			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setInt(1, e.getEmployeeId());
			ps.setInt(2, e.getManagerId());
			ps.setInt(3, e.getDeptId());
			ps.setString(4, e.getFirstName());
			ps.setString(5, e.getLastName());
			ps.setString(5, e.getUsername());
			ps.setString(5, e.getPassword());
			return 1;

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return -1;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		try {
			Connection conn = connFactory.getConnection();
			String sql = "SELECT * FROM employees WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt("employee_id"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setDeptId(rs.getInt("dept_id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
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
			Connection conn = connFactory.getConnection();
			String sql = "SELECT * FROM employees";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt("employee_id"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setDeptId(rs.getInt("dept_id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
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
			Connection conn = connFactory.getConnection();
			String sql = "UPDATE employees SET " + "			employee_id = ?, manager_id = ?, dept_id = ?, "
					+ "			firstName = ?, lastName = ?, username=?, password=? WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getEmployeeId());
			ps.setInt(2, e.getManagerId());
			ps.setInt(3, e.getDeptId());
			ps.setString(4, e.getFirstName());
			ps.setString(5, e.getLastName());
			ps.setString(5, e.getUsername());
			ps.setString(5, e.getPassword());
			return true;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		try {
			Connection conn = connFactory.getConnection();
			String sql = "DELETE FROM employees WHERE employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ps.executeQuery();
			return true;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee getByUserName(String username) {
		Employee employee = null;
		try {
			Connection conn = connFactory.getConnection();
			String sql = "SELECT * FROM employees WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt("employee_id"));
				e.setManagerId(rs.getInt("manager_id"));
				e.setDeptId(rs.getInt("dept_id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				return e;
			}
			return new Employee();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	private static Employee parseResultSet(ResultSet resultSet) {

		Employee employee = new Employee();

		try {
			employee.setEmployeeId(resultSet.getInt(1));
			employee.setManagerId(resultSet.getInt(2));
			employee.setDeptId(resultSet.getInt(3));
			employee.setFirstName(resultSet.getString(4));
			employee.setLastName(resultSet.getString(5));
			employee.setUsername(resultSet.getString(6));
			employee.setPassword(resultSet.getString(7));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public int create(Employee newObj) {
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
