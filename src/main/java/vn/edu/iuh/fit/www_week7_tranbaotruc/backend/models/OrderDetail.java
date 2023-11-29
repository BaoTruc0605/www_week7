package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.pkId.OrderDetailPK;

@Setter
@Getter
@NoArgsConstructor
@IdClass(OrderDetailPK.class)
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(length = 10, nullable = false)
    private int quantity;
    @Column(length = 20, nullable = false)
    private double price;
    @Column(columnDefinition = "nvarchar(255)")
    private String note;



    public OrderDetail(Orders order, Product product, int quantity, double price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
