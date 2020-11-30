package com.liang.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.sql.Savepoint;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @ClassName DeferredResultQueue
 * @Description TODO
 * @Author Liang Xi
 * @DATE 2020/11/28 9:53
 * @Version 1.0
 */
@Component
public class DeferredResultQueue {
    private static Queue<DeferredResult<String>> queue=new ConcurrentLinkedDeque<>();
    public static void save(DeferredResult<String> deferredResult){
        queue.add(deferredResult);
    }
    public static DeferredResult<String> get(){
        return queue.poll();
    }
}
