package com.kmust.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //@Configuration 相当于spring中的 applicationContext.xml
    //配置负载均衡实现RestTemplate
    //IRule
    /*
    AvailabilityFilteringRule:先过滤掉跳闸，访问故障的服务，对剩下的进行轮询
    RetryRule：重试 会先按照轮询获取服务，如果轮询失败就会在指定的时间内进行重试
    RoundRobinRule：轮询；默认
    RandomRule：随机
    public class WeightedResponseTimeRule：权重

     */
    @Bean
    @LoadBalanced //Ribbon
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }




}
