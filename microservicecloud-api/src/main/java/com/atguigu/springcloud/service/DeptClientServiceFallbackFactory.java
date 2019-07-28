package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public boolean add(Dept dept) {
                return false;
            }

            public Dept get(Long id) {
                return new Dept("无此部门fallback");
            }

            public List<Dept> list() {
                return null;
            }
        };
    }
}
