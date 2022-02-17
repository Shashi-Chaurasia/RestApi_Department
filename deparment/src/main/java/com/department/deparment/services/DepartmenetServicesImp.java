package com.department.deparment.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.department.deparment.entity.Department;
import com.department.deparment.error.DepartmentNotFoundException;
import com.department.deparment.respository.DepartmentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmenetServicesImp implements DepartmentServices{

    @Autowired
    public DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
       
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments(Department department) {
        return departmentRepository.findAll();
    }

    @Override
    public Department getByIdDepartment(Long depratmentId) throws DepartmentNotFoundException {
        Optional<Department> dOptional = departmentRepository.findById(depratmentId);
        if (!dOptional.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available !");
            
        }
        return dOptional.get();
    }

    @Override
    public Department updateDepartment(Department department, Long departmenId) {
        Department depDB = departmentRepository.findById(departmenId).get();

        if (Objects.nonNull(department.getDepName()) &&
         !"".equalsIgnoreCase(department.getDepName())) {
            depDB.setDepName(department.getDepName());
        }
        if (Objects.nonNull(department.getDeptAddress()) &&
         !"".equalsIgnoreCase(department.getDeptAddress())) {
            depDB.setDeptAddress(department.getDeptAddress());
        }
        if (Objects.nonNull(department.getDeptCode()) &&
         !"".equalsIgnoreCase(department.getDeptCode())) {
            depDB.setDeptCode(department.getDeptCode());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        
    }

    @Override
    public Department getByDepName(String depName) {
        return departmentRepository.findByDepName(depName);
     
    }

    
}
