package shop.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ages")
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
        if (!(o instanceof Age age1)) return false;
        return Objects.equals(getId(), age1.getId()) && Objects.equals(getAge(), age1.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge());
    }

    @Override
    public String toString() {
        return "Age{" +
                "id=" + id +
                ", age='" + age + '\'' +
                '}';
    }
}
