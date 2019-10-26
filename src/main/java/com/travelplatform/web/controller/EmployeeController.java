package com.travelplatform.web.controller;

import com.travelplatform.web.entities.Department;
import com.travelplatform.web.entities.Employee;
import com.travelplatform.web.mapper.DepartmentMapper;
import com.travelplatform.web.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired(required = false)
    EmployeeMapper employeeMapper;

    @Autowired(required = false)
    DepartmentMapper departmentMapper;
//    @GetMapping("/emp/{id}")
//    public Employee getEmployee(@PathVariable("id") Integer id){
//        return employeeMapper.getEmployeeById(id);
//    }

    @GetMapping("/emps")
    public String list(ModelMap model){
        Collection<Employee> employees = employeeMapper.getEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //
    @GetMapping("/emp")
    public String toAddPage(ModelMap model){
        model.addAttribute("depts", departmentMapper.getDepartments());
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        if (employee.getId() == null) {
            employeeMapper.InsertEmployee(employee);
            System.out.println("保存成功:" + employee);
        } else {
            System.out.println("Post错误");
        }
        return "redirect:/emps";
    }

    //
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap model){
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("depts",departments);
        Employee employee = employeeMapper.getEmployeeById(id);
        model.addAttribute("emp",employee);
        return "emp/add";
    }

    //
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeMapper.updateEmployee(employee);
        System.out.println("修改成功:" + employee);
        return "redirect:/emps";
    }
//    @PostMapping("/emp/{id}")
//    public String deleteEmployee(@PathVariable("id") Integer id){
//        employeeDao.delete(id);
//        return "redirect:/emps";
//    }
}
