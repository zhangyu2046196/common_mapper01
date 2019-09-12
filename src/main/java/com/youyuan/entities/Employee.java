package com.youyuan.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 员工bean
 * @date 2019/4/9 16:16
 *
 * 因为基本数据类型有默认值，Mybatis不能根据null进行判断，所以在Mybatis中所有变量或bean的属性都用基本数据
 * 类型的包装类
 *
 */
@Table(name = "tabple_emp")
public class Employee implements Serializable {
    private static final long serialVersionUID = -5490793402949563010L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    /**
     * 名称
     */
    private String empName;
    /**
     * 工资
     */
    @Column(name = "emp_salary_apple")
    private Double empSalary;
    /**
     * 年龄
     */
    private Integer empAge;

    public Employee() {
    }

    public Employee(Integer empId, String empName, Double empSalary, Integer empAge) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empAge=" + empAge +
                '}';
    }
}
