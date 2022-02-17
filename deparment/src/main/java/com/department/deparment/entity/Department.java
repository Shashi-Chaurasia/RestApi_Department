package com.department.deparment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dep_Id;

    @NotBlank(message = "Please add department name : ")
    private String depName;

    private String deptAddress;

    @Length(max = 10)
    private String deptCode;
    public long getDep_Id() {
        return dep_Id;
    }
    public void setDep_Id(long dep_Id) {
        this.dep_Id = dep_Id;
    }
    public String getDepName() {
        return depName;
    }
    public void setDepName(String depName) {
        this.depName = depName;
    }
    public String getDeptAddress() {
        return deptAddress;
    }
    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }
    public String getDeptCode() {
        return deptCode;
    }
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
   

  
    @Override
    public String toString() {
        return "Department [depName=" + depName + ", dep_Id=" + dep_Id + ", deptAddress=" + deptAddress + ", deptCode="
                + deptCode + "]";
    }



    
    
}
