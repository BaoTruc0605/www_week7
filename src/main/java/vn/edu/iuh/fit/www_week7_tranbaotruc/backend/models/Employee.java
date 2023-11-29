package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.enums.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "emp_id", length = 20)
    private long id;
    @Column(name = "full_name", nullable = false,columnDefinition = "nvarchar(50)")
    private String fullName;
    @Column(name = "dob", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String email;
    @Column(length = 255, nullable = false)
    private String phone;
    @Column(nullable = false,columnDefinition = "nvarchar(255)")
    private String address;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;

    public Employee(String fullName, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
