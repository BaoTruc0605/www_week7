package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.enums.*;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.pkId.ProductPricePK;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "product_price")
@IdClass(ProductPricePK.class)
public class ProductPrice {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "price_date_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(length = 20, nullable = false)
    private double price;
    @Column(columnDefinition = "nvarchar(255)")
    private String note;


    public ProductPrice(Product product, LocalDate date, double price, String note) {
        this.product = product;
        this.date = date;
        this.price = price;
        this.note = note;
    }


    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", date=" + date +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
