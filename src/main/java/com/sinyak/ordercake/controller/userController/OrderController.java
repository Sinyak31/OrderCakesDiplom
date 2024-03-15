package com.sinyak.ordercake.controller.userController;

import com.sinyak.ordercake.configSecurity.MyUserDetails;
import com.sinyak.ordercake.entity.*;
import com.sinyak.ordercake.service.CakeService;
import com.sinyak.ordercake.service.OrderService;
import com.sinyak.ordercake.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private CakeService cakeService;
    private ReviewService revService;



    @GetMapping("/index")
    public String mainPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails= (MyUserDetails)authentication.getPrincipal();
        List<Reviews> reviews = revService.findAll().stream().limit(5).toList();
        model.addAttribute("nameUser",myUserDetails);
        model.addAttribute("listReview",reviews);
        return "user/index";
    }

    /**
     * Получение и отображдение тортов из БД table 'cake'
     *Норм
     */
    @GetMapping("/choice")
    public String choiceCake(Model model) {
        List<Cake> cakes = cakeService.findAll();
        model.addAttribute("listCake", cakes);
        System.out.println(cakes.get(0).getId());
        return "user/choiceCake";
    }


    /**
     * Норм, нужно исправить код (уменьшить)
     */
    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("orderForm") OrderForm orderForm, @RequestParam("id") int id){
        Order order = orderForm.getOrder();
        Client client = orderForm.getClient();
        Delivery delivery = orderForm.getDelivery();
        CakeClient cakeClient = orderForm.getCakeClient();
        order.setDelivery(delivery);
        order.setClient(client);
        Optional<Cake> cake = cakeService.findCakeByID(id);
        cakeClient.setDescriptionCake(cake.get().getDescriptionCake());
        cakeClient.setNameCake(cake.get().getNameCake());
        cakeClient.setImage(cake.get().getImage());
        order.setCake(cakeClient);
        order.setDateOfCakeOrder(LocalDate.now());
        orderService.save(order);
        return "redirect:/index";
    }


    /**
     * Метод добавления отзыва в БД
     *Норм
     * @param reviews
     * @return
     */
    @PostMapping("/saveReviews")
    public String saveEmployee(@ModelAttribute("reviews") Reviews reviews) {
        System.out.println(reviews);
        revService.save(reviews);
        return "redirect:/index";
    }


    /**
     * НОРМ
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
     * Переход на страниц конструктора
     * @return
     */
    @GetMapping("/builder")
    public String builderCake() {
        return "user/builderCake";
    }



}
