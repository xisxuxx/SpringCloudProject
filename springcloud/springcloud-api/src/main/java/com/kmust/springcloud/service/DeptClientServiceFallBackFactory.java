package com.kmust.springcloud.service;

import com.kmust.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//降级
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public Dept queryById(Long id) {

                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>" + id + "没有到对应的信息，客户端提供了降级的信息，该服务已经关闭")
                        .setDb_source("没有数据");

            }

            public List<Dept> queryAll() {
                return null;
            }

            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
