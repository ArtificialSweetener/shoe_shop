package shop.entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "sizes")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size1 = (Size) o;
        return Objects.equals(id, size1.id) && Objects.equals(size, size1.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size);
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", size='" + size + '\'' +
                '}';
    }
}
