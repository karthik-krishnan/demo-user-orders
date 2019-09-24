package in.karthiks.demo.users.controller;

import in.karthiks.demo.users.model.Order;
import in.karthiks.demo.users.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserOrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}/orders")
    public List<Order> getUserDetails(@PathVariable String userId) {
        return orderService.getOrdersForUser(userId);
    }
}
