package com.itheima.order.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 自定义负载均衡策略, 实现根据  请求路径的hashcode   来决定是哪个服务处理这个请求
 * @Description:
 * @author: yp
 */
public class MyRule extends AbstractLoadBalancerRule {
    /**
     * 选择处理请求的服务
     * @param key
     * @return
     */
    @Override
    public Server choose(Object key) {
        //1.获得请求对象
        //获得请求属性对象, 是可以获得请求对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //2.获得请求路径,得出hashcode
        int hashCode = request.getRequestURI().toString().hashCode();
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        System.out.println("hashCode=" + hashCode);
        //3.获得所有的服务 (多个)
        List<Server> serverList = getLoadBalancer().getAllServers();
        //4.hashcode%服务的个数, 从List取出server返回
        Server server = serverList.get(hashCode % serverList.size());
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }


}
