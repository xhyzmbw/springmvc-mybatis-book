package com.ay.test;

import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;

/**
 * 描述：测试类
 * @author Ay
 * @create 2018/04/22
 **/
@Service
public class MyLoggerTest {

    public static void main(String[] args) {
        //实例化真实项目中业务类
        BusinessClassService businessClassService = new BusinessClassServiceImpl();
        //日志类的handler
        MyLoggerHandler myLoggerHandler = new MyLoggerHandler(businessClassService);
        //获得代理类对象
        BusinessClassService businessClass = (BusinessClassService)Proxy.newProxyInstance(businessClassService.getClass().getClassLoader(), businessClassService.getClass().getInterfaces(),myLoggerHandler);
        //执行代理类方法
        businessClass.doSomeThing();

    }
}
