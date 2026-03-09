package com.example.SpringBootCRUDops.Repository;

import com.example.SpringBootCRUDops.Entity.Department;
import org.springframework.data.repository.CrudRepository;

//this interface will have all the crud operations methods
public interface DepartmentRepo extends CrudRepository<Department, Long> {
}
