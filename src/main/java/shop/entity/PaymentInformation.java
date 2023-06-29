package shop.entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "payment_information")
public class PaymentInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @MapsId
    private PaymentTransaction paymentTransaction;

    private String paymentMethod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }

    public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentInformation that = (PaymentInformation) o;
        return Objects.equals(id, that.id) && Objects.equals(paymentTransaction, that.paymentTransaction) && Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentTransaction, paymentMethod);
    }

    @Override
    public String toString() {
        return "PaymentInformation{" +
                "id=" + id +
                ", paymentTransaction=" + paymentTransaction +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
