package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzl
 * @date 2019/7/14 0014- 18:12
 **/
 @Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept findById(Long id) {
        return deptDao.findById(id);
    }

    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
