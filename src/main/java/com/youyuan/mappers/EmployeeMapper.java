package com.youyuan.mappers;

import com.youyuan.entities.Employee;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhangyu
 * @version 1.0
 * @description 自定义接口需要继承通用Mapper的mapper接口,里面的泛型是要操作的表对应的bean
 * @date 2019/4/9 22:25
 */
public interface EmployeeMapper extends Mapper<Employee> {

}
