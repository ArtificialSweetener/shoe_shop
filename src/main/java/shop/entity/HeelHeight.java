package shop.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "heel_heights")
public class HeelHeight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCm() {
        return cm;
    }

    public void setCm(int cm) {
        this.cm = cm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeelHeight that)) return false;
        return getCm() == that.getCm() && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCm());
    }

    @Override
    public String toString() {
        return "HeelHeight{" +
                "id=" + id +
                ", cm=" + cm +
                '}';
    }
}
