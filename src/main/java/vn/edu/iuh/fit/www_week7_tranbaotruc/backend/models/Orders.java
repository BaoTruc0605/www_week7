package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", length = 20)
    private long id;
    @Column(name = "order_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "emp_id",nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Orders(LocalDate date, Employee employee, Customer customer) {
        this.date = date;
        this.employee = employee;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }
}
