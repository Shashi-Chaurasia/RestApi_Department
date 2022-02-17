package com.department.deparment.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.department.deparment.entity.Department;
import com.department.deparment.respository.DepartmentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DepartmentServicesTest {

    @Autowired
    private DepartmentServices departmentServices;


    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .depName("CE")
                .deptAddress("Ahemdabad")
                .deptCode("IT-C9")
                .dep_Id(87699876)
                .build();

        Mockito.when(departmentRepository.findByDepNameIgnoreCase("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on valid Department Name ")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String depName = "CE";
        Department found = departmentServices.getByDepName(depName);
        assertEquals(depName, found.getDepName());

    }

}
