package shop.dao;

import shop.entity.PaymentInformation;

public interface PaymentInformationDao {
    PaymentInformation save(PaymentInformation paymentInformation);
    PaymentInformation get(Long id);
    PaymentInformation remove(PaymentInformation paymentInformation);
}
