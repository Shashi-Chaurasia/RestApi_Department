package com.department.deparment.respository;

import static org.junit.jupiter.api.Assertions.*;

import com.department.deparment.entity.Department;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Controller;


@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .depName("Mechanical Enginner")
                .deptAddress("Delhi")
                .deptCode("IT-06")
                .build();


            testEntityManager.persist(department);
        
    }

    @Test
    public void whenGetById_thenReturnDepartment() {
        Department department = departmentRepository.getById(1L);
        assertEquals(department.getDepName(), "Mechanical Enginner");
        
    }

    
}
