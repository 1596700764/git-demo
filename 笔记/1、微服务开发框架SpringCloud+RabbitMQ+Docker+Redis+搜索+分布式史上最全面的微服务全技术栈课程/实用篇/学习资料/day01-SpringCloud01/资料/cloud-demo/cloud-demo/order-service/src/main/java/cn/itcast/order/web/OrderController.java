package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {


   @Autowired
   private OrderService orderService;

    //@SentinelResource("{orderId}")
    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId,@RequestHeader(value = "truth",required = false) String truth) {
        // 根据id查询订单并返回
        System.out.println("truth:"+truth);
        return orderService.queryOrderById(orderId);
    }

    @GetMapping({"update"})
    public String t1(){
        return "更新成功";
    }


    @GetMapping({"query"})
    public String t2(){
        orderService.queryGoods();
        return "查询成功";
    }

    @GetMapping({"save"})
    public String t3(){
        orderService.queryGoods();
        return "保存成功";
    }
}
