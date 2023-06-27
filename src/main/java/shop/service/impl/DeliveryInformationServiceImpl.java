package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.DeliveryInformationDao;
import shop.entity.DeliveryInformation;
import shop.service.DeliveryInformationService;
@Service
public class DeliveryInformationServiceImpl implements DeliveryInformationService {
    @Autowired
    private DeliveryInformationDao deliveryInformationDao;
    @Override
    public DeliveryInformation save(DeliveryInformation deliveryInformation) {
        return deliveryInformationDao.save(deliveryInformation);
    }

    @Override
    public DeliveryInformation get(Long id) {
        return deliveryInformationDao.get(id);
    }

    @Override
    public DeliveryInformation remove(DeliveryInformation deliveryInformation) {
        return deliveryInformationDao.remove(deliveryInformation);
    }
}
