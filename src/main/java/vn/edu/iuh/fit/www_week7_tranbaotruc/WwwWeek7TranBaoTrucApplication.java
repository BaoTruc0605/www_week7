package vn.edu.iuh.fit.www_week7_tranbaotruc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.enums.ProductStatus;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.*;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.*;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class WwwWeek7TranBaoTrucApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwwWeek7TranBaoTrucApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;
    @Autowired
    private CartRepository cartRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            Random rnd = new Random();
//            for(long i=10; i<40; i++){
//                Customer customer = new Customer("Tran Bao Truc "+i, "email_"+i+"@gmail.com","03380305"+i, "Go Vap "+i );
//                customerRepository.save(customer);
//                Employee employee = new Employee("Tran Phi Phat"+i, LocalDate.of(2002,5,(int) i-9), "email_"+i+"@gmail.com","03380302"+i, "Go Vap "+i , EmployeeStatus.ACTIVE);
//                employeeRepository.save(employee);
//
//                Product product = new Product("Item "+i,"desc "+i, (int) i,"manufacturerName "+i, ProductStatus.ACTIVE);
//                productRepository.save(product);
//                System.out.println(customer);
//                System.out.println(employee);
//                System.out.println(product);
//
//
//                ProductImage productImage = new ProductImage(productRepository.findById(i-9).get(),i-9+".png","good "+i );
//                ProductPrice productPrice = new ProductPrice(productRepository.findById(i-9).get(),LocalDate.of(2023,6,(int)i-9), i*10000, "note "+1);
//                System.out.println(productImage);
//                System.out.println(productPrice);
//                productImageRepository.save(productImage);
//                productPriceRepository.save(productPrice);
//            }
//            Cart cart = new Cart(customerRepository.findById(10l).get(),productRepository.findById(10l).get(),5);
//            cartRepository.save(cart);

//            cartRepository.updateQuantity(10l,2l,5);
        };
    }
}
