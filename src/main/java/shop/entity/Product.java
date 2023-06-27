package shop.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //relation
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    //relation
    @ManyToOne
    @JoinColumn(name = "heel_height_id")
    private HeelHeight heelHeight;

    //relation
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    //relation
    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    private int amountInStock;
    private double price;
    private String description;
    private String vendorCode;
    private String barcode;

    //relation
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    //relation
    @ManyToOne
    @JoinColumn(name = "age_id")
    private Age age;

    //relation
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    private byte[] productPhoto;
    private String productPhotoName;
    private LocalDateTime dateOfAddition;
    private boolean isDeletedByAdmin;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public HeelHeight getHeelHeight() {
        return heelHeight;
    }

    public void setHeelHeight(HeelHeight heelHeight) {
        this.heelHeight = heelHeight;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public byte[] getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(byte[] productPhoto) {
        this.productPhoto = productPhoto;
    }

    public String getProductPhotoName() {
        return productPhotoName;
    }

    public void setProductPhotoName(String productPhotoName) {
        this.productPhotoName = productPhotoName;
    }

    public LocalDateTime getDateOfAddition() {
        return dateOfAddition;
    }

    public void setDateOfAddition(LocalDateTime dateOfAddition) {
        this.dateOfAddition = dateOfAddition;
    }

    public boolean isDeletedByAdmin() {
        return isDeletedByAdmin;
    }

    public void setDeletedByAdmin(boolean deletedByAdmin) {
        isDeletedByAdmin = deletedByAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getAmountInStock() == product.getAmountInStock() && Double.compare(product.getPrice(), getPrice()) == 0 && isDeletedByAdmin() == product.isDeletedByAdmin() && Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getCategory(), product.getCategory()) && Objects.equals(getColor(), product.getColor()) && Objects.equals(getHeelHeight(), product.getHeelHeight()) && Objects.equals(getMaterial(), product.getMaterial()) && Objects.equals(getSize(), product.getSize()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getVendorCode(), product.getVendorCode()) && Objects.equals(getBarcode(), product.getBarcode()) && Objects.equals(getGender(), product.getGender()) && Objects.equals(getAge(), product.getAge()) && Objects.equals(getManufacturer(), product.getManufacturer()) && Arrays.equals(getProductPhoto(), product.getProductPhoto()) && Objects.equals(getProductPhotoName(), product.getProductPhotoName()) && Objects.equals(getDateOfAddition(), product.getDateOfAddition());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getCategory(), getColor(), getHeelHeight(), getMaterial(), getSize(), getAmountInStock(), getPrice(), getDescription(), getVendorCode(), getBarcode(), getGender(), getAge(), getManufacturer(), getProductPhotoName(), getDateOfAddition(), isDeletedByAdmin());
        result = 31 * result + Arrays.hashCode(getProductPhoto());
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", color=" + color +
                ", heelHeight=" + heelHeight +
                ", material=" + material +
                ", size=" + size +
                ", amountInStock=" + amountInStock +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", barcode='" + barcode + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", manufacturer=" + manufacturer +
                ", productPhoto=" + Arrays.toString(productPhoto) +
                ", productPhotoName='" + productPhotoName + '\'' +
                ", dateOfAddition=" + dateOfAddition +
                ", isDeletedByAdmin=" + isDeletedByAdmin +
                '}';
    }
}
