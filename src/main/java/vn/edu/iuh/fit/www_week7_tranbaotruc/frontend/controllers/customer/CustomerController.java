package vn.edu.iuh.fit.www_week7_tranbaotruc.frontend.controllers.customer;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Customer;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service.CustomerService;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public String login(Model model, @RequestParam("phone") String phone, HttpSession session){
        Optional<Customer> loginAccount = customerService.findCustomersByPhone(phone);
        if(loginAccount.isEmpty()){
            model.addAttribute("loginStatus", false);
        }
        else{
            model.addAttribute("loginAccount", loginAccount);
            return "/home";
        }
        return "/index";
    }
    @GetMapping("/home")
    public String home(Model model){
        return "/home";
    }


}
