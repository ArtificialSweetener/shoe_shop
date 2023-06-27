package shop.service;

import shop.entity.PaymentService;

public interface PaymentServiceService {
    PaymentService save(PaymentService paymentService);
    PaymentService get(Long id);
    PaymentService remove(PaymentService paymentService);
}
