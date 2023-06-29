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
        if (o == null || getClass() != o.getClass()) return false;
        HeelHeight that = (HeelHeight) o;
        return cm == that.cm && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cm);
    }

    @Override
    public String toString() {
        return "HeelHeight{" +
                "id=" + id +
                ", cm=" + cm +
                '}';
    }
}
