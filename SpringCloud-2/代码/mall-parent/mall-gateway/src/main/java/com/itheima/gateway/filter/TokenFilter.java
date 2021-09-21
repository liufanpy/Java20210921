package com.itheima.gateway.filter;

import com.alibaba.nacos.common.utils.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @author: yp
 */
@Component
public class TokenFilter implements GlobalFilter, Ordered {


    /**
     * 过滤的方法 来自于GlobalFilter
     *
     * @param exchange: 获得web对象的 eg: 请求对象 响应对象
     * @param chain:    过滤器链
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获得请求对象 响应对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //如果是用户的登录和注册需要放行
        String uri = request.getURI().getPath();
        if(uri.contains("/user/login") || uri.contains("/user/regist")){
            return  chain.filter(exchange);
        }


        //2.获得请求头token  请求头有多个, 一个请求头可能存在一个key多个value的情况;  request.getHeaders().get("token").get(0);
        String token = request.getHeaders().getFirst("token");


        //3.校验token
        if (StringUtils.isEmpty(token)) {
            //3.1 校验失败, 拦截
            response.setStatusCode(HttpStatus.UNAUTHORIZED); //设置状态码401
            return response.setComplete();  //完成响应
        }

        //3.2 校验成功, 放行
        return  chain.filter(exchange);
    }

    /**
     * 决定顺序的方法 来源于Ordered
     *
     * @return 返回值越小, 优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
