package shop.service;

import shop.entity.OrderStatus;

public interface OrderStatusService {
    OrderStatus save(OrderStatus orderStatus);
    OrderStatus get(Long id);
    OrderStatus remove(OrderStatus orderStatus);
}
