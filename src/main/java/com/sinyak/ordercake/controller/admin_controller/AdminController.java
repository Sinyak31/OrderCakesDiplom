package com.sinyak.ordercake.controller.admin_controller;

import com.sinyak.ordercake.entity.Cake;
import com.sinyak.ordercake.entity.Categories;
import com.sinyak.ordercake.entity.Client;
import com.sinyak.ordercake.entity.Reviews;
import com.sinyak.ordercake.model.User;
import com.sinyak.ordercake.service.*;
import com.sinyak.ordercake.service.emailService.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private CakeService cakeService;
    private ReviewService revService;
    private CategoriesService categoriesService;
    private ClientService clientService;
    private UserService userService;
    private EmailService emailService;

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

    @PostMapping("/add-category")
    public String addCategory(@ModelAttribute("category") Categories categories, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if (!Objects.equals(Base64.getEncoder().encodeToString(file.getBytes()), "")) {
            String pictureAsString = Base64.getEncoder().encodeToString(file.getBytes());
            categories.setImage(pictureAsString);
        }
        categoriesService.saveCategories(categories);
        return "redirect:/admin/categories";
    }

    @GetMapping("/categories")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String choiceCategories(Model model) {
        List<Categories> categories = categoriesService.findAll();
        model.addAttribute("listCategories", categories);

        return "admin/categories";
    }

    @GetMapping("/panel")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String panelAdminShow() {

        return "admin/adminPanel";
    }

    @GetMapping("/user-management")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String userManagement(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("userList", users);
        return "admin/userManagement";
    }

    @PostMapping("/send-message")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String sendMessage(@RequestParam("email") String email, @RequestParam("subject") String subject,
                              @RequestParam("text") String text) {
        emailService.sendSimpleEmail(email, subject, text);
        return "redirect:/admin/user-management";
    }


    @GetMapping("/send-message/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getCakeById(@PathVariable("id") int id, Model model) {
        Optional<User> user = userService.findUserByID(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
        return "admin/sendMessage";
    }



    @GetMapping("/updateRole/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getUpdateUserForm(@PathVariable("id") int id, @ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", userService.findUserByID(id).get());
        return "/admin/updateRole";
    }


    @PostMapping("/updateRole/{id}")
    public String updateRole(@PathVariable("id") int id, @ModelAttribute("user") User user) throws IOException {

        userService.updateUser(id, user);
        return "redirect:/admin/user-management";
    }







//    @PostMapping("/add-category")
//    public String addCategory(@ModelAttribute("category") Categories categories, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
//        if (!Objects.equals(Base64.getEncoder().encodeToString(file.getBytes()), "")) {
//            String pictureAsString = Base64.getEncoder().encodeToString(file.getBytes());
//            categories.setImage(pictureAsString);
//        }
//        categoriesService.saveCategories(categories);
//        return "redirect:/admin/categories";
//    }
//
//    @GetMapping("/categories")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String choiceCategories(Model model) {
//        List<Categories> categories = categoriesService.findAll();
//        model.addAttribute("listCategories", categories);
//
//        return "admin/categories";
//    }
//
//
//    @GetMapping("/categories/{id}")
//    public String getCategoriesById(@PathVariable("id") int id, Model model) {
//        Optional<Categories> categories = categoriesService.findCategoriesByID(id);
//        System.out.println("До сюда дошло "+categories.get().getCakeList());
//        List<Cake> cake =
//                System.out.println(cake);
//        model.addAttribute("cakesInCategory",cake);
//        return "redirect:/admin/index";
//    }

}

