package shop.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToMany
    @JoinTable(name = "cities_delivery_services",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "delivery_service_id"))
    private List<DeliveryService> availableDeliveryServices;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<DeliveryService> getAvailableDeliveryServices() {
        return availableDeliveryServices;
    }

    public void setAvailableDeliveryServices(List<DeliveryService> availableDeliveryServices) {
        this.availableDeliveryServices = availableDeliveryServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return Objects.equals(getId(), city.getId()) && Objects.equals(getName(), city.getName()) && Objects.equals(getCountry(), city.getCountry()) && Objects.equals(getAvailableDeliveryServices(), city.getAvailableDeliveryServices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry(), getAvailableDeliveryServices());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", availableDeliveryServices=" + availableDeliveryServices +
                '}';
    }
}
