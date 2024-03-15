package com.sinyak.ordercake.controller.guestControler;

import com.sinyak.ordercake.entity.Cake;
import com.sinyak.ordercake.entity.Reviews;
import com.sinyak.ordercake.service.CakeService;
import com.sinyak.ordercake.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class GuestController {

    private CakeService cakeService;
    private ReviewService revService;


    @GetMapping("/")
    public String mainPageForGoth(Model model){
        List<Reviews> reviews = revService.findAll();
        model.addAttribute("listReview",reviews);
        return "guest/index";
    }

    @GetMapping("/ch")
    public String choiceCake(Model model) {
        List<Cake> cakes = cakeService.findAll();
        model.addAttribute("listCake", cakes);
        return "guest/choiceCake";
    }
}
