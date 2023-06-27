package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.OrderStatusDao;
import shop.entity.OrderStatus;
import shop.service.OrderStatusService;
@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    private OrderStatusDao orderStatusDao;
    @Override
    public OrderStatus save(OrderStatus orderStatus) {
        return orderStatusDao.save(orderStatus);
    }

    @Override
    public OrderStatus get(Long id) {
        return orderStatusDao.get(id);
    }

    @Override
    public OrderStatus remove(OrderStatus orderStatus) {
        return orderStatusDao.remove(orderStatus);
    }
}
