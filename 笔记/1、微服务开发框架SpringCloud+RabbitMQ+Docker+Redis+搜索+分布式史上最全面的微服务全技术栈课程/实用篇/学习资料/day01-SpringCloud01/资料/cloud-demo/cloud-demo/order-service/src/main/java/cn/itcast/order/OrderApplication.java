package cn.itcast.order;


import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.config.FeignClientConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
                    //全局生效                                            包
@EnableFeignClients(defaultConfiguration = FeignClientConfiguration.class
        ,basePackages = "cn.itcast.feign.clients"
        ,clients = UserClient.class)
//@ComponentScan("cn.itcast.feign")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

   /* @Bean
    public IRule randomRule() {
        return new RandomRule();
    }*/
}