package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Cart;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Customer;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Employee;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Product;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.CartRepository;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void add(Cart cart) {
        cartRepository.save(cart);
    }

    public Optional<Cart> findById(long id) {
        return cartRepository.findById(id);
    }

    public List<Cart> findCartsByCustomer_Id(long id) {
        return cartRepository.findCartsByCustomer_Id(id);
    }

    public Optional<Cart> findCartByCustomerIdAndAndProductId(long cusId, long proId) {
        return cartRepository.findCartByCustomerIdAndAndProductId(cusId, proId);
    }
    @Transactional
    public Integer updateQuantity(long cusId,long proId, int quantity) {
        return cartRepository.updateQuantity(cusId, proId, quantity);
    }


}
