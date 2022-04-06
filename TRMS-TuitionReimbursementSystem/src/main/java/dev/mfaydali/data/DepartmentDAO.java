package dev.mfaydali.data;

import java.util.List;

import dev.mfaydali.models.Department;

public interface DepartmentDAO extends GenericDAO<Department>{

	@Override
	int create(Department dept);

	public List<Department> getAllDepartments();

}
