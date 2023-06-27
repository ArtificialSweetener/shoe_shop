package shop.entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String mobilePhone;
    private byte [] salt;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<UserRole> roles;

    @OneToOne(mappedBy = "owner")
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "owner")
    private List<Order> orders;

    private boolean isBlocked;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return isBlocked() == user.isBlocked() && Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getMobilePhone(), user.getMobilePhone()) && Arrays.equals(getSalt(), user.getSalt()) && Objects.equals(getRoles(), user.getRoles()) && Objects.equals(getOrders(), user.getOrders());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getSurname(), getEmail(), getPassword(), getMobilePhone(), getRoles(), getOrders(), isBlocked());
        result = 31 * result + Arrays.hashCode(getSalt());
        return result;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", salt=" + Arrays.toString(salt) +
                ", roles=" + roles +
                ", orders=" + orders +
                ", isBlocked=" + isBlocked +
                '}';
    }


}
