package shop.dao;

import shop.entity.PaymentService;

public interface PaymentServiceDao {
    PaymentService save(PaymentService paymentService);
    PaymentService get(Long id);
    PaymentService remove(PaymentService paymentService);
}
