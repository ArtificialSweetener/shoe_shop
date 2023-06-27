package shop.dao;

import shop.entity.OrderStatus;

public interface OrderStatusDao {
    OrderStatus save(OrderStatus orderStatus);
    OrderStatus get(Long id);
    OrderStatus remove(OrderStatus orderStatus);
}
