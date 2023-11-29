package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Customer;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> findCustomersByPhone(String phone){
        return customerRepository.findCustomerByPhone(phone);
    }
    public Optional<Customer> findById(long id){
        return customerRepository.findById(id);
    }


}
