package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Customer;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {

}
