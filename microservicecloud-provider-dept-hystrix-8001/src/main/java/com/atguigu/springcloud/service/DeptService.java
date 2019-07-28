package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;

import java.util.List;

/**
 * @author zzl
 * @date 2019/7/14 0014- 18:10
 **/
public interface DeptService {

    boolean addDept(Dept dept);
    Dept findById(Long id);
    List<Dept> findAll();

}
