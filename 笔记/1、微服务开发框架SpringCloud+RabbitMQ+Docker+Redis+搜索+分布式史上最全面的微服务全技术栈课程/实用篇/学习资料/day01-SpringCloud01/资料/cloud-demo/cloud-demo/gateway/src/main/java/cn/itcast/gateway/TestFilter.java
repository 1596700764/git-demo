package cn.itcast.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(1)//order值越小，优先级越高，执行顺序越靠前。
public class TestFilter implements GlobalFilter {
    /*需求：定义全局过滤器，拦截请求，判断请求的参数是否满足下面条件：

            - 参数中是否有authorization，
            - authorization参数值是否为admin

    如果同时满足则放行，否则拦截*/

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求参数
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();

        //2.获取authorization
        String first = params.getFirst("authorization");
        //判断是否含有admin
        if(first.contains("admin")){
                    //放行exchange
            return chain.filter(exchange);
        }
        //做出响应：禁止
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        //完成响应，结束
        return exchange.getResponse().setComplete();
    }
}
