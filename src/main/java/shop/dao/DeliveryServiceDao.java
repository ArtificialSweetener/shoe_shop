package shop.dao;

import shop.entity.DeliveryService;

public interface DeliveryServiceDao {
    DeliveryService save(DeliveryService deliveryService);
    DeliveryService get(Long id);
    DeliveryService remove(DeliveryService deliveryService);
}
