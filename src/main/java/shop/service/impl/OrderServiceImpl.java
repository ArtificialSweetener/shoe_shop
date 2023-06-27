package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.OrderDao;
import shop.entity.Order;
import shop.entity.User;
import shop.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public Order save(Order order) {
        return orderDao.save(order);
    }

    @Override
    public Order get(Long id) {
        return orderDao.get(id);
    }

    @Override
    public Order remove(Order order) {
        return orderDao.remove(order);
    }

    @Override
    public List<Order> findAll(User user) {
        return orderDao.findAll(user);
    }
}
