package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.PaymentInformationDao;
import shop.entity.PaymentInformation;
import shop.service.PaymentInformationService;
@Service
public class PaymentInformationServiceImpl implements PaymentInformationService {
    @Autowired
   private PaymentInformationDao paymentInformationDao;
    @Override
    public PaymentInformation save(PaymentInformation paymentInformation) {
        return paymentInformationDao.save(paymentInformation);
    }

    @Override
    public PaymentInformation get(Long id) {
        return paymentInformationDao.get(id);
    }

    @Override
    public PaymentInformation remove(PaymentInformation paymentInformation) {
        return paymentInformationDao.remove(paymentInformation);
    }
}
