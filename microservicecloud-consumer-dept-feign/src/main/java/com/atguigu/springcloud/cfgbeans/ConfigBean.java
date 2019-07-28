package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zzl
 * @date 2019/7/14 0014- 20:27
 **/
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon 实现的一套客户端 负载均衡工具
    public RestTemplate getRestTemplate(){
          return new RestTemplate();
    }

    @Bean
    public IRule myRule(){//达到的目标，用我们重新选择的随机算法替代默认的轮询
//        return new RandomRule();
        return new RetryRule();
    }

}
