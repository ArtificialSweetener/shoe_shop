package shop.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_statuses")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderStatus that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getStatusName(), that.getStatusName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatusName());
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
