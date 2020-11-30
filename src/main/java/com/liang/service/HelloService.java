package com.liang.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author Liang Xi
 * @DATE 2020/11/27 19:45
 * @Version 1.0
 */
@Service
public class HelloService {
    public String sayHello(String name){
        return "hello"+name ;
    }

}
