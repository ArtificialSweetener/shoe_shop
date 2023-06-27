package shop.dao;

import shop.entity.PaymentTransaction;

public interface PaymentTransactionDao {
    PaymentTransaction save(PaymentTransaction paymentTransaction);
    PaymentTransaction get(Long id);
    PaymentTransaction remove(PaymentTransaction paymentTransaction);
}
