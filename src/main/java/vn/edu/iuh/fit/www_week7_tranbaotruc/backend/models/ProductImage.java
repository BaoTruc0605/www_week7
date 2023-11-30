package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", length = 20, nullable = false)
    private long imageId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String path;
    @Column(nullable = false,columnDefinition = "nvarchar(255)")
    private String alternative;


    public ProductImage(Product product, String path, String alternative) {
        this.product = product;
        this.path = path;
        this.alternative = alternative;
    }


    @Override
    public String toString() {
        return "ProductImage{" +
                "product=" + product +
                ", imageId=" + imageId +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}
