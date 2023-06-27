package shop.service;

import shop.entity.DeliveryService;

public interface DeliveryServiceService {
    DeliveryService save(DeliveryService deliveryService);
    DeliveryService get(Long id);
    DeliveryService remove(DeliveryService deliveryService);
}
