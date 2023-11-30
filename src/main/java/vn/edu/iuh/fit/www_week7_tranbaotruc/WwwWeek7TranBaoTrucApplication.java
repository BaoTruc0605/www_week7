package vn.edu.iuh.fit.www_week7_tranbaotruc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.repository.*;

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
    private ProductImageRepository prodcutImageRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            Random rnd = new Random();
            for(long i=10; i<40; i++){
////
//                Customer customer = new Customer("Tran Bao Truc "+i, "email_"+i+"@gmail.com","03380305"+i, "Go Vap "+i );
//                customerRepository.save(customer);
//                Employee employee = new Employee("Tran Phi Phat"+i, LocalDate.of(2002,5,(int) i-9), "email_"+i+"@gmail.com","03380302"+i, "Go Vap "+i , EmployeeStatus.ACTIVE);
//                employeeRepository.save(employee);
//
//                Product product = new Product("Item "+i,"desc "+i, (int) i,"manufacturerName "+i,ProductStatus.ACTIVE);
//                productRepository.save(product);
//                System.out.println(customer);
//                System.out.println(employee);
//                System.out.println(product);
// public ProductPrice(Product product, LocalDate date, double price, String note) {
//                    this.product = product;
//                    this.date = date;
//                    this.price = price;
//                    this.note = note;
//                }

//                ProductImage productImage = new ProductImage(productRepository.findById(i-9).get(),i-9+".png","good "+i );
//            ProductPrice productPrice = new ProductPrice(productRepository.findById(i-9).get(),LocalDate.of(2023,6,(int)i-9), i*10000, "note "+1);
//            System.out.println(productImage);
//                System.out.println(productPrice);
//                prodcutImageRepository.save(productImage);
//                productPriceRepository.save(productPrice);
            }
        };
    }
}
