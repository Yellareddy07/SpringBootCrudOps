package com.example.SpringBootCRUDops.Services;

import com.example.SpringBootCRUDops.Entity.Department;
import com.example.SpringBootCRUDops.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepo repo;
    @Override
    public List<Department> fetchDepartment() {
        return (List<Department>)
                repo.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return repo.save(department);
    }

    @Override
    public Department updateDepartment(Department department, Long did) {
        Department d = repo.findById(did).get();

        if (Objects.nonNull(department.getDname()) && !"".equalsIgnoreCase(department.getDname())) {
            d.setDname(department.getDname());
        }
        if (Objects.nonNull(department.getDaddress()) && !"".equalsIgnoreCase(department.getDaddress())) {
            d.setDaddress(department.getDaddress());
        }
        if (Objects.nonNull(department.getDcode()) && !"".equalsIgnoreCase(department.getDcode())) {
            d.setDcode(department.getDcode());
        }

        return repo.save(d);
    }

    @Override
    public void deleteDepartment(Long did) {
         repo.deleteById(did);
    }
}
