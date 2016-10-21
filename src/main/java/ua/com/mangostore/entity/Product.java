package ua.com.mangostore.entity;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(nullable = false, name = "PRODUCT_TITLE")
    private String productTitle;

    @Column(nullable = false, name = "TYPE")
    private String type;

    @Column(nullable = false, name = "BRAND_NAME")
    private String brandName;

    @Column(nullable = false, name = "FULL_PRICE")
    private double fullPrice;

    @Column(name = "SALE_PRICE")
    private double salePrice;

    @Column(nullable = false, name = "SPECIFICATION")
    private String specification;

    @Column(nullable = false, name = "IMAGE_URL")
    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //
//    @ManyToMany()
//    @JoinTable(name = "ProductOrder",
//            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")})
//    List<Order> orders = new ArrayList<>();

    public Product() {
    }

    public Product(String productTitle, String type, String brandName, double fullPrice, double salePrice) {
        this.productTitle = productTitle;
        this.type = type;
        this.brandName = brandName;
        this.fullPrice = fullPrice;
        this.salePrice = salePrice;
    }

    public Product(String productTitle, String type, String brandName,
                   double fullPrice, double salePrice,
                   String specification, String image) {
        this.productTitle = productTitle;
        this.type = type;
        this.brandName = brandName;
        this.fullPrice = fullPrice;
        this.salePrice = salePrice;
        this.specification = specification;
        this.imageURL = image;
    }

//    public void addOrder(Order order) {
//        if (!orders.contains(order))
//            orders.add(order);
//        if (!order.products.contains(this))
//            order.products.add(this);
//    }

    public double getPrice() {
        return fullPrice;
    }

    public void setPrice(double price) {
        this.fullPrice = price;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!productTitle.equals(product.productTitle)) return false;
        return order != null ? order.equals(product.order) : product.order == null;

    }

    @Override
    public int hashCode() {
        int result = productTitle.hashCode();
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", type='" + type + '\'' +
                ", brandName='" + brandName + '\'' +
                ", fullPrice=" + fullPrice +
                ", salePrice=" + salePrice +
                ", specification='" + specification + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}