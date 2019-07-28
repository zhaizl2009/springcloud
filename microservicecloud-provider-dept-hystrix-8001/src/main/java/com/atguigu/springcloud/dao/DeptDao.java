package com.atguigu.springcloud.dao;
import com.atguigu.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zzl
 * @date 2019/7/14 0014- 17:57
 **/
@Mapper
public interface DeptDao {
   boolean addDept(Dept dept);
   Dept findById(Long id);
   List<Dept> findAll();
}
