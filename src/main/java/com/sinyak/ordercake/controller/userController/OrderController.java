package com.sinyak.ordercake.controller.userController;

import com.sinyak.ordercake.configSecurity.MyUserDetails;
import com.sinyak.ordercake.entity.Cake;
import com.sinyak.ordercake.entity.OrderForm;
import com.sinyak.ordercake.entity.Reviews;
import com.sinyak.ordercake.service.CakeService;
import com.sinyak.ordercake.service.OrderService;
import com.sinyak.ordercake.service.ReviewService;
import com.sinyak.ordercake.service.emailService.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class OrderController {


    private OrderService orderService;
    private CakeService cakeService;
    private ReviewService revService;
    private EmailService emailService;



    @GetMapping("/index")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public String mainPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails= (MyUserDetails)authentication.getPrincipal();
        List<Reviews> reviews = revService.findAll();
        model.addAttribute("nameUser",myUserDetails);
        model.addAttribute("listReview",reviews);
        return "user/index";
    }

    /**
     * Получение и отображдение тортов из БД table 'cake'
     */
    @GetMapping("/choice")
    public String choiceCake(Model model) {
        List<Cake> cakes = cakeService.findAll();
        model.addAttribute("listCake", cakes);
        return "user/choiceCake";
    }


    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("orderForm") OrderForm orderForm, @RequestParam("id") int id){
        orderService.save(orderForm,id);
        emailService.sendMessageToAdmin(orderForm.getOrder()); //Оповещение админа о новом заказе по email
        emailService.sendMessageToClientAfterOrdering(orderForm.getOrder()); //Оповещение клиента о заказе по email
        return "redirect:/index";
    }


    /**
     * Метод добавления отзыва в БД
     * @param reviews
     */
    @PostMapping("/saveReviews")
    public String saveEmployee(@ModelAttribute("reviews") Reviews reviews) {
        revService.save(reviews);
        return "redirect:/index";
    }


    /**
     *Метод получения деталей заказа
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/order_details/{id}")
    public String getCakeById(@PathVariable("id") int id, Model model) {
        Optional<Cake> cake = cakeService.findCakeByID(id);
        if (cake.isPresent()) {
            model.addAttribute("cake", cake.get());
        }
        return "user/orderDetails";
    }





    /**
     * Переход на страниу конструктора
     * @return
     */
    @GetMapping("/builder")
    public String builderCake() {
        return "user/builderCake";
    }



}
