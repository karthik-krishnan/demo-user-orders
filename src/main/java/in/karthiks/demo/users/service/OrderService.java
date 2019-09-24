package in.karthiks.demo.users.service;

import in.karthiks.demo.users.dto.OrderDTO;
import in.karthiks.demo.users.model.Order;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public List<Order> getOrdersForUser(String userId) {
        RestTemplate restTemplate = new RestTemplate();
        String serviceUrl = "http://localhost:8080/orders?userId=";

        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(
                serviceUrl + userId, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<OrderDTO>>(){});

        List<OrderDTO> ordersList = response.getBody();
        ArrayList userOrders = new ArrayList<Order>(ordersList.size());
        ordersList.forEach(orderDTO -> userOrders.add(new Order(orderDTO.orderId, orderDTO.orderAmount)));
        return userOrders;
    }
}
