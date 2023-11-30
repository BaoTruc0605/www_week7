package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Cart;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Customer;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findCartsByCustomer_Id(long id);
}
