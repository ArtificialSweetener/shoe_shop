package shop.entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "delivery_information")
public class DeliveryInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private DeliveryService deliveryService;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    //nullable
    private String address;
    //nullable
    private String postalCode;
    //nullable
    private String postOfficeNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryService getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostOfficeNumber() {
        return postOfficeNumber;
    }

    public void setPostOfficeNumber(String postOfficeNumber) {
        this.postOfficeNumber = postOfficeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryInformation that = (DeliveryInformation) o;
        return Objects.equals(id, that.id) && Objects.equals(deliveryService, that.deliveryService) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(address, that.address) && Objects.equals(postalCode, that.postalCode) && Objects.equals(postOfficeNumber, that.postOfficeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deliveryService, country, city, address, postalCode, postOfficeNumber);
    }

    @Override
    public String toString() {
        return "DeliveryInformation{" +
                "id=" + id +
                ", deliveryService=" + deliveryService +
                ", country=" + country +
                ", city=" + city +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", postOfficeNumber='" + postOfficeNumber + '\'' +
                '}';
    }
}
