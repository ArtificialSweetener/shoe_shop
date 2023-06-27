package shop.service;

import shop.entity.PaymentInformation;

public interface PaymentInformationService {
    PaymentInformation save(PaymentInformation paymentInformation);
    PaymentInformation get(Long id);
    PaymentInformation remove(PaymentInformation paymentInformation);
}
