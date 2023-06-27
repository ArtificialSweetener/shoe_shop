package shop.entity;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender gender1)) return false;
        return Objects.equals(getId(), gender1.getId()) && Objects.equals(getGender(), gender1.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGender());
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }
}
