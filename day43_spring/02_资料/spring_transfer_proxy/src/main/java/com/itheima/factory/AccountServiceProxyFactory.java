package com.itheima.factory;

import com.itheima.service.AccountService;
import com.itheima.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component("accountServiceProxyFactory")
public class AccountServiceProxyFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager txManager;

    public AccountService createProxy(){
        return (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;

                        try {
                            //开启事务
                            txManager.startTransaction();
                            //调用目标对象的方法：执行转账
                            result = method.invoke(accountService, args);
                            //提交事务
                            txManager.commitAndClose();
                        } catch (Exception e) {
                            e.printStackTrace();
                            //回滚事务
                            txManager.rollbackAndClose();
                        }
                        return result;
                    }
                }
        );
    }
}