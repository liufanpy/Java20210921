package com.itheima.filter;

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
 * @author ljh
 * @version 1.0
 * @date 2021/3/13 11:48
 * @description 标题
 * @package com.itheima.filter
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    //实现的业务逻辑：判断当前有登录，有 放行，没有返回错误
    //模拟：如果请求参数 有一个参数名为token 并且值为123456 认为就登录了
    // http://localhost:18084/api/item/1234?token=123456&token=5678
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求对象request
        ServerHttpRequest request = exchange.getRequest();
        //2.获取响应对象response
        ServerHttpResponse response = exchange.getResponse();
        //3.获取请求参数名为token的值 判断 如果没有 返回错误 如果有 就放行
        String tokenValue = request.getQueryParams().getFirst("token");

        if(!"123456".equals(tokenValue)){
            //错误 没登录
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //放行继续执行过滤器
        return chain.filter(exchange);
    }

    //排序的值 值越低 过滤器被执行的优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
