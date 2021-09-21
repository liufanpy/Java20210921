package com.itheima.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/13 12:08
 * @description 标题
 * @package com.itheima.filter
 */
@Component
public class MyParamGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                //1.获取到配置文件yml中的配置信息：头名 和 头值
                String headerName  = config.getName();//头名
                String headerValue = config.getValue();//头值
                //2.将头名和头值封装 设置到请求中 转发给下游微服务
                //设置头
                exchange.getRequest().mutate().header(headerName,headerValue);
                //放行传递过去下游微服务
                return chain.filter(exchange);
            }
        };
    }
}
