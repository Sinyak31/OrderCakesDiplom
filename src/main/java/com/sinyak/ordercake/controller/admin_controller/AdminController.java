package com.sinyak.ordercake.controller.admin_controller;

import com.sinyak.ordercake.entity.Cake;
import com.sinyak.ordercake.entity.Reviews;
import com.sinyak.ordercake.service.CakeService;
import com.sinyak.ordercake.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private CakeService cakeService;
    private ReviewService revService;

    //удаления коментария
    @GetMapping("/deleteReviews/{id}")
    public String deleteReviews(@PathVariable("id") int id) {
        revService.deleteByID(id);
        return "redirect:/admin/index";
    }

    //метод перехода на главную страницу админа и загрузка коментариев
    @GetMapping("/index")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String mainPage(Model model) {
        List<Reviews> reviews = revService.findAll();
        model.addAttribute("listReview", reviews);
        return "/admin/indexAdmin";
    }


    //переход на страницу выбора торта для админа
    @GetMapping("/choice")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String choiceCake(Model model) {
        List<Cake> cakes = cakeService.findAll();
        model.addAttribute("listCake", cakes);
        return "admin/admin-choice";
    }


    //Метод добавление торта
    @PostMapping("/add-cake")
//        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addCake(@ModelAttribute("cake") Cake cake, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (!Objects.equals(Base64.getEncoder().encodeToString(file.getBytes()), "")) {
            String pictureAsString = Base64.getEncoder().encodeToString(file.getBytes());
            cake.setImage(pictureAsString);
        }

        cakeService.saveCake(cake);
        return "redirect:/admin/choice";
    }

    @GetMapping("/deleteCake/{id}")
    public String deleteCake(@PathVariable("id") int id) {
        cakeService.deleteCakeById(id);
        return "redirect:/admin/choice";
    }

    @GetMapping("/updateCake/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getUpdateCakeForm(@PathVariable("id") int id, @ModelAttribute("cake") Cake cake, Model model) {
        model.addAttribute("cake", cakeService.findCakeByID(id).get());
        return "/admin/updateCake";
    }

    @PostMapping("/updateCake/{id}")
    public String updateCake(@PathVariable("id") int id, @ModelAttribute("cake") Cake cake, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (!Objects.equals(Base64.getEncoder().encodeToString(file.getBytes()), "")) {
            String pictureAsString = Base64.getEncoder().encodeToString(file.getBytes());
            cake.setImage(pictureAsString);
        }
        cakeService.updateCake(id, cake);
        return "redirect:/admin/choice";
    }

}

