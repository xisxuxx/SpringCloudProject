package com.kmust.springcloud.controller;

import com.kmust.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    /*
        如何调用到Service层？
        理解：消费者不该有Service层
        SpringCloud支持RestFul风格
        RestTemplate .... 供我们直接调用就可以了！但需要注册到Spring中
         (url,实体：Map,Class<T> responseType)
     */

    @Autowired
    private RestTemplate restTemplate;//提供多种边界访问远程http服务的方法，简单的restful服务模板。

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //使用ribbon时，这里应该是变量
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    //http://localhost:8001/dept/list
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" +id,Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }


}
