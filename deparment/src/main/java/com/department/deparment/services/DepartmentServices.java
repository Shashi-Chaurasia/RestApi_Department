package com.department.deparment.services;

import java.util.List;

import com.department.deparment.entity.Department;
import com.department.deparment.error.DepartmentNotFoundException;



public interface DepartmentServices {

    public Department saveDepartment(Department department);

    public List<Department> getDepartments(Department department);

    public Department getByIdDepartment(Long departmenId) throws DepartmentNotFoundException;

    public Department updateDepartment(Department department, Long departmenId);

    public void deleteDepartment(Long departmentId);

    public Department getByDepName(String depName);


   
}
