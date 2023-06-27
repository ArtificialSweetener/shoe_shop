package shop.service;

import shop.entity.DeliveryInformation;

public interface DeliveryInformationService {
    DeliveryInformation save(DeliveryInformation deliveryInformation);
    DeliveryInformation get(Long id);
    DeliveryInformation remove(DeliveryInformation deliveryInformation);
}
