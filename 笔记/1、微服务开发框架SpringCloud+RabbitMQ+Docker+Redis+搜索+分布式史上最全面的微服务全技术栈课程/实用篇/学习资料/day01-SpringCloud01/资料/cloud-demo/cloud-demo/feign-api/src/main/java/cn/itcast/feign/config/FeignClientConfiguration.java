package cn.itcast.feign.config;

//import cn.itcast.feign.clients.fallback.UserClientFallBackFactory;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class FeignClientConfiguration {
    @Bean                                        //BASIC修改日志级别
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }

    /*@Bean
    public UserClientFallBackFactory userClientFallBackFactory(){
        return new UserClientFallBackFactory();
    }*/
}
