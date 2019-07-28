package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptService;
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

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return service.addDept(dept);
    }
    @RequestMapping(value="/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return service.findAll();
    }


    //服务发现
    @RequestMapping(value="/discovery")
    public Object discovery(){
        List<String> list=client.getServices();
        System.out.println("*********"+list);
        List<ServiceInstance> srvList=client.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance element:srvList){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+
                    element.getPort()+"\t"+element.getUri());
        }
        return this.client;
    }
}
