package shop.entity;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "payment_services")
public class PaymentService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String apiKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentService that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getApiKey(), that.getApiKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getApiKey());
    }

    @Override
    public String toString() {
        return "PaymentService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}
