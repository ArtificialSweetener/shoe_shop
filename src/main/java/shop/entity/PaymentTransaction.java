package shop.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "payment_transactions")
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "payment_service_id")
    private PaymentService paymentService;

    @OneToOne(mappedBy = "paymentTransaction")
    private PaymentInformation paymentInformation;

    private String transactionId;

    private double amount;
    private String status;
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentTransaction that)) return false;
        return Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getPaymentService(), that.getPaymentService()) && Objects.equals(getTransactionId(), that.getTransactionId()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getTimestamp(), that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrder(), getPaymentService(), getTransactionId(), getAmount(), getStatus(), getTimestamp());
    }

    @Override
    public String toString() {
        return "PaymentTransaction{" +
                "id=" + id +
                ", order=" + order +
                ", paymentService=" + paymentService +
                ", transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
