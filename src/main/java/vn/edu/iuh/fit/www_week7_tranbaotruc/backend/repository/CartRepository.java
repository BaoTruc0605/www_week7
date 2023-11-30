package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Cart;


import java.util.List;
import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("from Cart where quantity>0 and customer.id=:id")
    List<Cart> findCartsByCustomer_Id(long id);
    Optional<Cart> findCartByCustomerIdAndAndProductId(long cusId,long proId);
    @Modifying
    @Query("update Cart set quantity =:quantity where (customer.id =:cusId and product.id =:proId)")
    Integer updateQuantity(long cusId,long proId, int quantity);
}
