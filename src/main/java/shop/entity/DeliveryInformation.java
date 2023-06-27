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
        if (!(o instanceof DeliveryInformation that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDeliveryService(), that.getDeliveryService()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getPostalCode(), that.getPostalCode()) && Objects.equals(getPostOfficeNumber(), that.getPostOfficeNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeliveryService(), getCountry(), getCity(), getAddress(), getPostalCode(), getPostOfficeNumber());
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
