package shop.entity;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "age")
public class Age {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Age age1 = (Age) o;
        return Objects.equals(id, age1.id) && Objects.equals(age, age1.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age);
    }

    @Override
    public String toString() {
        return "Age{" +
                "id=" + id +
                ", age='" + age + '\'' +
                '}';
    }
}
