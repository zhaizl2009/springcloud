package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zzl
 * @date 2019/7/14 0014- 18:17
 **/
@RestController
@RequestMapping(value="dept")
public class DeptController {
    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value="/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = service.findById(id);
        if(null==dept){
            throw new RuntimeException();
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept("无此部门");
    }



}
