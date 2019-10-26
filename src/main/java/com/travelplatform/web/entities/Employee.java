package com.travelplatform.web.entities;
//有少部分JPA的事例标签，暂时不用，用mybatis
//import javax.persistence.*;
import java.util.Date;
//@Entity
//@Table(name = "employee")
public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//    @Column
    private String lastName;
//    @Column
    private String email;
    //1 male, 0 female
    private Integer gender;
    private Integer departmentId;
    private Date birth;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", departmentId=" + departmentId +
                ", birth=" + birth +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
