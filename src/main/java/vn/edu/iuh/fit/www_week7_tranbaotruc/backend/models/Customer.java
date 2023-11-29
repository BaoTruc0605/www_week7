package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", length = 20)
    private long id;
    @Column(name="cust_name",nullable = false,columnDefinition = "nvarchar(50)")
    private String name;
    @Column(length = 255, nullable = false)
    private String email;
    @Column(length = 255,nullable = false,columnDefinition = "nvarchar(255)")
    private String phone;
    @Column(nullable = false,columnDefinition = "nvarchar(255)")
    private String address;
    @OneToMany(mappedBy = "customer")
   private List<Orders> orders;

    public Customer(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
