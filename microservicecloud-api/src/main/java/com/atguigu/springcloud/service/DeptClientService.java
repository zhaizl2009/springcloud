package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zzl
 * @date 2019/7/18 0018- 21:43
 **/
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    boolean add(@RequestBody Dept dept);
    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    Dept get(@PathVariable("id") Long id);
    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    List<Dept> list();
}
