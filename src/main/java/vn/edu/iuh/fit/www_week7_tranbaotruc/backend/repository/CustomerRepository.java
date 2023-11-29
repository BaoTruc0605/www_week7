package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Customer;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findCustomerByPhone(String phone);
}
