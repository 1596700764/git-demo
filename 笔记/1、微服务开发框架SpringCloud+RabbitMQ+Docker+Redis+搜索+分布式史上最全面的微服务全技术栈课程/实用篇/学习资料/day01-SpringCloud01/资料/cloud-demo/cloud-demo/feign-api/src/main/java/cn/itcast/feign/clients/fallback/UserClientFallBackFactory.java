package cn.itcast.feign.clients.fallback;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/*@Slf4j//日志类注解
public class UserClientFallBackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(Long id) {
                //log.error("用户信息查询",throwable);
                System.err.println("出现错误");
                return new User();
            }
        };
    }
}*/
