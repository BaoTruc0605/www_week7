package vn.edu.iuh.fit.www_week7_tranbaotruc.frontend.controllers.customer;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Cart;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Customer;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.models.Product;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service.CartService;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service.CustomerService;
import vn.edu.iuh.fit.www_week7_tranbaotruc.backend.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;


    @PostMapping("/login")
    public String login(Model model, @RequestParam("phone") String phone, HttpSession session) {
        Optional<Customer> loginAccount = customerService.findCustomersByPhone(phone);
        if (loginAccount.isEmpty()) {
            model.addAttribute("loginStatus", false);
        } else {
            model.addAttribute("loginAccount", loginAccount);
            List<Product> products = productService.getAll();
            model.addAttribute("products", products);
            List<Cart> carts = cartService.findCartsByCustomer_Id(loginAccount.get().getId());
            model.addAttribute("carts", carts);
            return "/home";
        }
        return "/index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "/home";
    }

    @PostMapping("/cart")
    public String addCart(Model model, RedirectAttributes redirectAttributes, @RequestParam("productId") Long productId, @RequestParam("customerId") Long customerId,
                          HttpSession session) {

        Optional<Cart> cartOptional = cartService.findCartByCustomerIdAndAndProductId(customerId, productId);
        if (cartOptional.isEmpty()) {
            Cart cart = new Cart(customerService.findById(customerId).get(), productService.findById(productId).get(), 1);
            cartService.add(cart);
        } else {
            int a = cartService.updateQuantity(cartOptional.get().getCustomer().getId(), cartOptional.get().getProduct().getId(), cartOptional.get().getQuantity() + 1);
            System.out.println(cartOptional.get().getQuantity() + 1);
        }
        redirectAttributes.addAttribute("customerId", customerId + "");
        return "redirect:/showCart";
    }

    @PostMapping("/desCart")
    public String desCart(Model model, RedirectAttributes redirectAttributes, @RequestParam("productId") Long productId, @RequestParam("customerId") Long customerId,
                          HttpSession session) {

        Optional<Cart> cartOptional = cartService.findCartByCustomerIdAndAndProductId(customerId, productId);

        int a = cartService.updateQuantity(cartOptional.get().getCustomer().getId(), cartOptional.get().getProduct().getId(), cartOptional.get().getQuantity() - 1);
        System.out.println(cartOptional.get().getQuantity() + 1);
        redirectAttributes.addAttribute("customerId", customerId + "");
        return "redirect:/showCart";
    }

    @GetMapping("/showCart")
    public String showCart(Model model, @RequestParam("customerId") String customerId, HttpSession session) {
        List<Cart> carts = cartService.findCartsByCustomer_Id(Long.parseLong(customerId));
        List<Product> products = new ArrayList<>();
        for (Cart cart : carts
        ) {
            products.add(productService.findById(cart.getProduct().getId()).get());
        }
        model.addAttribute("carts", carts);
        model.addAttribute("products", products);
        model.addAttribute("customerId", customerId);
        return "customer/cart";
    }


}
