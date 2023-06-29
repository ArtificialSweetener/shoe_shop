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
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(name, city.name) && Objects.equals(country, city.country) && Objects.equals(availableDeliveryServices, city.availableDeliveryServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, availableDeliveryServices);
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
