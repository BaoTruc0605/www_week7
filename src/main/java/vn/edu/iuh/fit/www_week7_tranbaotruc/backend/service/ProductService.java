package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Employee;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Product;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.EmployeeRepository;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void add(Product product){
        productRepository.save(product);
    }
    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }


}
