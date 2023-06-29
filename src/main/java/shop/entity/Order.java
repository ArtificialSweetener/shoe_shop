package shop.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User owner;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    private double totalPrice;

    private boolean isPhoneCallAcceptable;

    @ManyToOne
    @JoinColumn(name = "delivery_info_id")
    private DeliveryInformation deliveryInformation;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    private List<PaymentTransaction> paymentTransactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPhoneCallAcceptable() {
        return isPhoneCallAcceptable;
    }

    public void setPhoneCallAcceptable(boolean phoneCallAcceptable) {
        isPhoneCallAcceptable = phoneCallAcceptable;
    }

    public DeliveryInformation getDeliveryInformation() {
        return deliveryInformation;
    }

    public void setDeliveryInformation(DeliveryInformation deliveryInformation) {
        this.deliveryInformation = deliveryInformation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<PaymentTransaction> getPaymentTransactions() {
        return paymentTransactions;
    }

    public void setPaymentTransactions(List<PaymentTransaction> paymentTransactions) {
        this.paymentTransactions = paymentTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalPrice, totalPrice) == 0 && isPhoneCallAcceptable == order.isPhoneCallAcceptable && Objects.equals(id, order.id) && Objects.equals(owner, order.owner) && Objects.equals(products, order.products) && Objects.equals(deliveryInformation, order.deliveryInformation) && Objects.equals(comment, order.comment) && Objects.equals(orderStatus, order.orderStatus) && Objects.equals(orderDate, order.orderDate) && Objects.equals(paymentTransactions, order.paymentTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, products, totalPrice, isPhoneCallAcceptable, deliveryInformation, comment, orderStatus, orderDate, paymentTransactions);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", owner=" + owner +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                ", isPhoneCallAcceptable=" + isPhoneCallAcceptable +
                ", deliveryInformation=" + deliveryInformation +
                ", comment='" + comment + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderDate=" + orderDate +
                ", paymentTransactions=" + paymentTransactions +
                '}';
    }
}
