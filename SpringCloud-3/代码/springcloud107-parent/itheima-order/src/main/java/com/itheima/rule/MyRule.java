package com.itheima.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancer;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/11 15:48
 * @description 标题
 * @package com.itheima.rule
 */
public class MyRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        //1.先获取当前的请求的路径
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(requestAttributes!=null) {
            HttpServletRequest request = requestAttributes.getRequest();
            //2.使用hash方法获取hashcode
            int i = request.getRequestURL().toString().hashCode();
            if(i<0){
                i=0;
            }
            //3.用hashcode的值对 服务列表的长度求余数
            int index = i%getLoadBalancer().getAllServers().size();
            //4.根据下标获取服务列表中的某一个服务
            return getLoadBalancer().getAllServers().get(index);

        }
        return null;
    }
}
