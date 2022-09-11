package cn.itcast.feign.clients;

//import cn.itcast.feign.clients.fallback.UserClientFallBackFactory;
import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//restful风格
@FeignClient(value = "userservice")//,fallbackFactory = UserClientFallBackFactory.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);


}
