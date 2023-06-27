package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.PaymentServiceDao;
import shop.entity.PaymentService;
import shop.service.PaymentServiceService;
@Service
public class PaymentServiceServiceImpl implements PaymentServiceService {
    @Autowired
    private PaymentServiceDao paymentServiceDao;
    @Override
    public PaymentService save(PaymentService paymentService) {
        return paymentServiceDao.save(paymentService);
    }

    @Override
    public PaymentService get(Long id) {
        return paymentServiceDao.get(id);
    }

    @Override
    public PaymentService remove(PaymentService paymentService) {
        return paymentServiceDao.remove(paymentService);
    }
}
