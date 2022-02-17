package com.department.deparment.controller;

import java.util.List;

import javax.validation.Valid;

import com.department.deparment.entity.Department;
import com.department.deparment.error.DepartmentNotFoundException;
import com.department.deparment.services.DepartmentServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    
    @PostMapping("/departments")
    public Department saveDepartments(@Valid @RequestBody Department department){

        logger.info("Inside save Departments");
        return departmentServices.saveDepartment(department);
    }

    //----------------------Get Mappig -------------------------
    @GetMapping("/departments")
    public List<Department> getDepartments(@RequestBody Department department){
        logger.info("Inside getDepartments");
        return departmentServices.getDepartments(department);
    }

    //----------------------Get mapping by id-----------------------
    @GetMapping("/departments/{id}")
    public Department getByIdDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException{
        logger.info("Inside GetByIdDepartments");
        return departmentServices.getByIdDepartment(departmentId);
    }

    //------------------------Get By Name ---------------------------
    @GetMapping("/departments/name/{name}")
    public Department getByDepName(@PathVariable("name") String depName){
        logger.info("Inside GetByDepName");
        return departmentServices.getByDepName(depName);
    }

    //-----------------------Update Mapping------------------------------
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmenId){

        logger.info("Inside updateDepartments");
        return departmentServices.updateDepartment(department , departmenId);
        
    }

    //------------------------Delete Mapping ------------------------------
    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId){
        logger.info("Inside DeleteDepartments");
        this.departmentServices.deleteDepartment(departmentId);

    }


  

   
    
}
