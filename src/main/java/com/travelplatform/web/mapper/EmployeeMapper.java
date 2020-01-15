package com.travelplatform.web.mapper;

import com.travelplatform.web.po.Employee;

import java.util.Collection;

public interface EmployeeMapper {

    public Employee getEmployeeById(Integer id);

    public void InsertEmployee(Employee employee);

    public Collection<Employee> getEmployees();

    public void updateEmployee(Employee employee);

    public void deleteEmployee(Integer id);
}
