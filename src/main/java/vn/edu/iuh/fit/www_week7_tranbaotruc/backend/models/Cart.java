package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.pkId.CartPK;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.pkId.ProductPricePK;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CartPK.class)
@Entity
@Table(name="cart")
public class Cart {
    @Id
    @ManyToOne
    @JoinColumn(name = "emp_id",nullable = false)
    private Employee employee;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(length = 10, nullable = false)
    private int quantity;

    public double getTotalPrice(){
        return product.getPrice()*quantity;
    }

}
