package com.liang.controller;

import com.liang.service.DeferredResultQueue;
import com.liang.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Liang Xi
 * @DATE 2020/11/27 19:45
 * @Version 1.0
 */
@Controller
public class HelloController {
    @Autowired
    HelloService helloService;
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        String xixi = helloService.sayHello("xixi");
        return xixi;
    }
    @RequestMapping("/hello1")
    public String hello1(){
        return "index";
    }
    @RequestMapping("/async")
    @ResponseBody
    public Callable<String> async(){
        System.out.println("主线程开始"+Thread.currentThread().getName()+System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("副线程开始"+Thread.currentThread().getName()+System.currentTimeMillis());
                sayhello();
                System.out.println("副线程结束"+Thread.currentThread().getName()+System.currentTimeMillis());
                return "hello";
            }
        };
        System.out.println("主线程结束"+Thread.currentThread().getName()+System.currentTimeMillis());
        return callable;
    }
    public void sayhello() throws InterruptedException {
       Thread.sleep(3000);
    }
    @RequestMapping("createorder")
    @ResponseBody
    public DeferredResult<String> createOrder(){
        DeferredResult<String> deferredResult=new DeferredResult<>();
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }
    @RequestMapping("order")
    @ResponseBody
    public String order(){
        DeferredResult<String> deferredResult = DeferredResultQueue.get();
        String string = UUID.randomUUID().toString();
        boolean success = deferredResult.setResult(string);
        return string;

    }
}
