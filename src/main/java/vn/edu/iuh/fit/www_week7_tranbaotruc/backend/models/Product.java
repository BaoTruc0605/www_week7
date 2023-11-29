package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.enums.ProductStatus;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", length = 20)
    private long id;
    @Column(nullable = false,columnDefinition = "nvarchar(255)")
    private String name;
    @Column(nullable = false,columnDefinition = "nvarchar(255)")
    private String description;
    @Column(nullable = false)
    private int unit;
    @Column(nullable = false,columnDefinition = "nvarchar(255)", name ="nanufacturer_name")
    private String manufacturerName;
    @Column(nullable = false)
    private ProductStatus status;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;
    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    public double getPrice(){
        if(getProductPrices().isEmpty()){
            return 0;
        }else{
            return getProductPrices().get(getProductPrices().size()-1).getPrice();
        }
    }


    public Product(String name, String description, int unit, String manufacturerName, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

}
