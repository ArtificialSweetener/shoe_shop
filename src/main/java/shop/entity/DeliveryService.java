package shop.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "delivery_services")
public class DeliveryService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    ///list of all cities, where this delivery shop.service is available;
    @ManyToMany(mappedBy = "availableDeliveryServices")
    private List<City> citiesWhereAvailable;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<City> getCitiesWhereAvailable() {
        return citiesWhereAvailable;
    }

    public void setCitiesWhereAvailable(List<City> citiesWhereAvailable) {
        this.citiesWhereAvailable = citiesWhereAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryService that = (DeliveryService) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(citiesWhereAvailable, that.citiesWhereAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, citiesWhereAvailable);
    }

    @Override
    public String toString() {
        return "DeliveryService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", citiesWhereAvailable=" + citiesWhereAvailable +
                '}';
    }
}
