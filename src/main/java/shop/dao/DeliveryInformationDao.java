package shop.dao;

import shop.entity.DeliveryInformation;

public interface DeliveryInformationDao {
    DeliveryInformation save(DeliveryInformation deliveryInformation);
    DeliveryInformation get(Long id);
    DeliveryInformation remove(DeliveryInformation deliveryInformation);
}
