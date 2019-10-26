package com.travelplatform.web.controller;

import com.travelplatform.web.entities.Department;
import com.travelplatform.web.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//只返回json数据
@RestController
public class DeptController {
    @Autowired(required = false)
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.getDepartmentById(id);
    }

    @GetMapping("/dept")
    public Department insertDepartment(Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }

}
