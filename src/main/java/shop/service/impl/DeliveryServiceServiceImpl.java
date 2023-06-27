package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.DeliveryServiceDao;
import shop.entity.DeliveryService;
import shop.service.DeliveryServiceService;
@Service
public class DeliveryServiceServiceImpl implements DeliveryServiceService {
    @Autowired
    private DeliveryServiceDao deliveryServiceDao;
    @Override
    public DeliveryService save(DeliveryService deliveryService) {
        return deliveryServiceDao.save(deliveryService);
    }

    @Override
    public DeliveryService get(Long id) {
        return deliveryServiceDao.get(id);
    }

    @Override
    public DeliveryService remove(DeliveryService deliveryService) {
        return deliveryServiceDao.remove(deliveryService);
    }
}
