package com.example.SpringBootCRUDops.Services;

import com.example.SpringBootCRUDops.Entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DepartmentService {
    //this interface will have all the crud methods to implement in Departmentserviceimpl class

    //read operation
    List<Department> fetchDepartment();

    //save operation
    Department saveDepartment(Department department);

    //update
    Department updateDepartment(Department department,Long did);

    //delete
    void deleteDepartment(Long did);

}
