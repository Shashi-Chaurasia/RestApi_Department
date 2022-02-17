package com.department.deparment.respository;

import com.department.deparment.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
    public Department findByDepName(String deptName);
    public Department findByDepNameIgnoreCase(String deptName);
}
