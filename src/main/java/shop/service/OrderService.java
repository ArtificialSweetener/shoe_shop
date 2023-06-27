package shop.service;

import shop.entity.Order;
import shop.entity.User;

import java.util.List;

public interface OrderService {
    Order save(Order order);
    Order get(Long id);
    Order remove(Order order);
    List<Order> findAll(User user);
}
