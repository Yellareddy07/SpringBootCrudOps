package com.example.SpringBootCRUDops.Controller;

import com.example.SpringBootCRUDops.Entity.Department;
import com.example.SpringBootCRUDops.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/fetch")
    public List<Department> fetchDepartment(){
        return departmentService.fetchDepartment();
    }


    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }


    @PutMapping("/Put/{id}")
    public Department updateDepartment(@RequestBody Department department,@PathVariable("id") Long did){
        return departmentService.updateDepartment(department, did);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable ("id") Long did){
        departmentService.deleteDepartment(did);
        return "Deleted Successfully";
    }

}
