package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author zzl
 * @date 2019/7/14 0014- 20:34
 **/
@RestController
public class DeptController_Consumer {


    @Autowired
    private DeptClientService service;


    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){
        return service.add(dept);
    }
    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable(name="id") Long id){
//        if(true) throw new RuntimeException();
        return service.get( id);
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(Long id){
        return service.list();
    }





}


