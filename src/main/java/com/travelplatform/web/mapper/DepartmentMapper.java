package com.travelplatform.web.mapper;

import com.travelplatform.web.po.Department;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    public Department getDepartmentById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDepartmentById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDepartment(Department department);

    @Update("update department set departmentName=#{departmentName} where id = #{id}")
    public int updateDepartment(Department department);

    @Select("select * from department")
    public Collection<Department> getDepartments();
}
