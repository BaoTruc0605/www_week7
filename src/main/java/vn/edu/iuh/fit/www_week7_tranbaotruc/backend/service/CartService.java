package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Cart;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Employee;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.CartRepository;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void add(Cart cart){
        cartRepository.save(cart);
    }
    public Optional<Cart> findById(long id){
        return cartRepository.findById(id);
    }
    public List<Cart> findCartsByCustomer_Id(long id){
        return cartRepository.findCartsByCustomer_Id(id);
    }

}
