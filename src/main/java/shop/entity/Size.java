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
        if (!(o instanceof Size size1)) return false;
        return Objects.equals(getId(), size1.getId()) && Objects.equals(getSize(), size1.getSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSize());
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", size='" + size + '\'' +
                '}';
    }
}
