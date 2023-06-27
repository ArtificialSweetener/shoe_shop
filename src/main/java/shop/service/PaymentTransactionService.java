package shop.service;

import shop.entity.PaymentTransaction;

public interface PaymentTransactionService {
    PaymentTransaction save(PaymentTransaction paymentTransaction);
    PaymentTransaction get(Long id);
    PaymentTransaction remove(PaymentTransaction paymentTransaction);
}
