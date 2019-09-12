package com.youyuan;

import com.youyuan.entities.Employee;
import com.youyuan.services.EmployeeService;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 测试
 * @date 2019/4/10 21:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class EmployeeMapperTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSelectOne(){
        //创建查询条件bean
        Employee employeeQueryCondition=new Employee(null,null,null,null);
        //查询
        Employee employeeQueryResult=employeeService.getOne(employeeQueryCondition);
        //打印查询结果
        System.out.println(employeeQueryResult);
    }

    @Test
    public void testSelectByPrimaryKey(){
        //指定主键值
        Integer primaryKey=3;
        //查询
        Employee employeeResult=employeeService.selectByPrimaryKey(primaryKey);
        //打印查询结果
        System.out.println(employeeResult);
    }
    
    @Test
    public void testInsert(){
        //创建bean
        Employee employee = new Employee(null, "emp03", 3000.98, 29);
        //保存
        Integer empId= employeeService.insertEmployee(employee);
        //打印保存结果
        System.out.println(employee.getEmpId());
    }

    @Test
    public void testInsertSelective(){
        //创建对象
        Employee employee = new Employee(null, "emp04", null, 32);
        //插入
        employeeService.insertSelective(employee);
    }

    @Test
    public void testUpdateByPrimaryKeySelective(){
        //创建更新对象
        Employee employee = new Employee(9, null, 9792.86, null);
        //执行更新操作
        employeeService.updateByPrimaryKeySelective(employee);
    }

    @Test
    public void testDeleteByPrimaryKey(){
        //要删除的主键
        Integer empId=19;
        //执行删除操作
        employeeService.deleteByPrimaryKey(empId);
    }

    @Test
    public void testDelete(){
        //删除的实体
        Employee employee=null;
        //执行删除操作
        employeeService.delete(employee);
    }

    @Test
    public void testQueryByExample(){
        //测试QBC  query by criteria  查询   java将查询条件封装成实体中
        //目标sql语句  where (emp_salary_apple>? and emp_age<?) or (emp_salary_apple<? and emp_age>?)
        //步骤
        //1、创建Example   传递的参数class是要操作的数据库表对应的实体
        Example example = new Example(Employee.class);
        //================Example可以设置一些常用属性================
        example.setDistinct(true);//去重
        example.orderBy("empSalary").desc();//排序
        //2、根据目标sql语句，需要创建两个Criteria
        Example.Criteria criteria1 = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();
        //3、封装两个括号里面的查询语句
        //3.1、封装 emp_salary_apple>? and emp_age<?   语句
        //     property:代表实体类属性  类比sql中的emp_salary_apple
        //     value:代表属性值
        //     andGreaterThan  代表property>value
        //     andLessThan   代表property<value
        criteria1.andGreaterThan("empSalary",3000);
        criteria1.andLessThan("empAge",25);
        //3.2、封装 emp_salary_apple<? and emp_age>?   语句
        criteria2.andLessThan("empSalary",5000);
        criteria2.andGreaterThan("empAge",30);
        //4、拼装or    example代表了criteria1
        example.or(criteria2);
        //5、执行查询
        List<Employee> employeeList=employeeService.queryByExample(example);
        //6、打印
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }

    @Test
    public void testSelectByRowBounds(){
        //分页测试  注意：RowBounds分页查询的时候是全部查询出来放到内存在(只查询一次)，在按页数返回，没有执行limit,数据量大的情况下不适用
        Integer page=2;//页数
        Integer limitNum=2;//每页数
        Integer index=(page-1)*limitNum;//开始位置
        RowBounds rowBounds=new RowBounds(index,limitNum);
        List<Employee> employeeList=employeeService.selectByRowBounds(rowBounds);
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }

}
