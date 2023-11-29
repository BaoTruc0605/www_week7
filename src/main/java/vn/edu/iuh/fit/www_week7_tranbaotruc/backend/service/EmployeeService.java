package vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Customer;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Employee;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.CustomerRepository;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> findEmployeeByPhone(String phone){
        return employeeRepository.findEmployeeByPhone(phone);
    }
    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }


}
