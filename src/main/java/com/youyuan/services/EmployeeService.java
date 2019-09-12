package com.youyuan.services;

import com.youyuan.entities.Employee;
import com.youyuan.mappers.EmployeeMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description
 * @date 2019/4/9 22:29
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getOne(Employee employeeQueryCondition) {
        return (Employee) employeeMapper.selectOne(employeeQueryCondition);
    }

    public Employee selectByPrimaryKey(Integer primaryKey) {
        return employeeMapper.selectByPrimaryKey(primaryKey);
    }

    public Integer insertEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    public void insertSelective(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public void updateByPrimaryKeySelective(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteByPrimaryKey(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
    }

    public void delete(Employee employee) {
        employeeMapper.delete(employee);
    }

    public List<Employee> queryByExample(Example example) {
        return employeeMapper.selectByExample(example);
    }

    public List<Employee> selectByRowBounds(RowBounds rowBounds) {
        return employeeMapper.selectByRowBounds(null,rowBounds);
    }
}
