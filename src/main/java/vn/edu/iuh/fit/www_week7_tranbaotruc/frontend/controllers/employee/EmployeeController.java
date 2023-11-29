package vn.edu.iuh.fit.www_week7_tranbaotruc.frontend.controllers.employee;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Employee;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service.EmployeeService;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/loginEmployee")
    public String login(Model model, @RequestParam("phone") String phone, HttpSession session){
        Optional<Employee> loginAccount = employeeService.findEmployeeByPhone(phone);
        if(loginAccount.isEmpty()){
            model.addAttribute("loginStatus", false);
        }
        else{
            model.addAttribute("loginAccount", loginAccount);
            return "/homeEmployee";
        }
        return "/index";
    }
    @GetMapping("/homeEmployee")
    public String home(Model model){
        return "/homeEmployee";
    }


}
