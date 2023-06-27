package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.PaymentTransactionDao;
import shop.entity.PaymentTransaction;
import shop.service.PaymentTransactionService;

@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {
    @Autowired
    PaymentTransactionDao paymentTransactionDao;
    @Override
    public PaymentTransaction save(PaymentTransaction paymentTransaction) {
        return paymentTransactionDao.save(paymentTransaction);
    }

    @Override
    public PaymentTransaction get(Long id) {
        return paymentTransactionDao.get(id);
    }

    @Override
    public PaymentTransaction remove(PaymentTransaction paymentTransaction) {
        return paymentTransactionDao.remove(paymentTransaction);
    }
}
