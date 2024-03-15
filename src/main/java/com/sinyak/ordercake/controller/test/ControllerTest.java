package com.sinyak.ordercake.controller.test;

import com.sinyak.ordercake.service.CakeService;
import com.sinyak.ordercake.service.OrderService;
import com.sinyak.ordercake.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ControllerTest {

    private OrderService orderService;
    private CakeService cakeService;
    private ReviewService revService;
//    private CakeProbaService cakeProbaService;


//    @RequestMapping("/ad")
//    public String addorder(){
//        Client client = new Client("Игнат","Мокеев","sindyai31@gmail.com","89084855525");
//        Delivery delivery = new Delivery("Варейкиса 23",36,14);
//        Order order = new Order("Курица",30000,client,delivery);
//        orderRepository.save(order);
//        return "index";
//
//    }
//@RequestMapping("/addImg")
//    public String addImage(){
//        ImagesCake imagesCake = new ImagesCake("images/2.png","Супер торт");
//        imagesRepository.save(imagesCake);
//        return "index";
//    }
//
//    @RequestMapping("/getIm")
//    public String getIm(Model model){
//        ImagesCake imagesCake = imagesRepository.getReferenceById(3);
//     model.addAttribute("img",imagesCake.getUrl());
//        System.out.println(imagesCake.getUrl());
//     return "proba";
//    }

//    /**
//     * Получение и отображдение тортов из БД table 'cake'
//     *Норм
//     * @param model
//     * @return
//     */
//    @RequestMapping("/choice")
//    public String choiceCake(Model model) {
//        List<Cake> cakes = cakeService.findAll();
//        model.addAttribute("listCake", cakes);
//        System.out.println(cakes.get(0).getId());
//        return "choiceCake";
//    }

    /**
     * Переход на страниц конструктора
     * @return
     */
    @RequestMapping("/builder")
    public String builderCake() {
        return "builderCake";
    }


//    @RequestMapping("/addNewReviews")
//    public String addNewEmployee(Model model){
//        Reviews reviews = new Reviews();
//       model.addAttribute("review",reviews);
//    }

//    /**
//     * Метод добавления отзыва в БД
//     *Норм
//     * @param reviews
//     * @return
//     */
//    @RequestMapping("/saveReviews")
//    public String saveEmployee(@ModelAttribute("reviews") Reviews reviews) {
//        revService.save(reviews);
//        return "redirect:/";
//    }
//
//    /**
//     *Метод отображенгия отзывов
//     * @param model
//     * @return
//     */
//    @RequestMapping("/showReviews")
//    public String showEmployee(Model model){
//
//        return "redirect:/";
//    }
//    @RequestMapping("/admin")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//public String prosto(){
//    return "indexAdmin";
//}

//    @RequestMapping("/choice/{id}")
//public String getCake(@PathVariable(name = "id") int id, Model model){
//        Optional<Cake> cake = cakeService.getCakeFindById(id);
//        model.addAttribute("cake", cake);
//        System.out.println(cake);
//        return "redirect:/choice";
//}


//@RequestMapping("/order_details")
//public String orderDetails(@RequestParam(name = "id") int id, Model model){
//    Optional<Cake> cake = cakeService.getCakeFindById(id);
//    model.addAttribute("cake", cake);
//        return "orderDetails";
//}
//
//    /**
//     * НОРМ
//     *
//     * @param id
//     * @param model
//     * @return
//     */
//    @RequestMapping("/order_details/{id}")
//    public String getCakeById(@PathVariable("id") int id, Model model) {
//        Optional<Cake> cake = cakeService.getCakeFindById(id);
//        if (cake.isPresent()) {
//            model.addAttribute("cake", cake.get());
//        }
//        return "orderDetails";
//    }


//    /**
//     * Норм, нужно исправить код (уменьшить)
//     * @param orderForm
//     * @param id
//     * @return
//     */
//    @RequestMapping("/addOrder")
//    public String addOrder(@ModelAttribute("orderForm")OrderForm orderForm,@RequestParam("id") int id){
//Order order = orderForm.getOrder();
//Client client = orderForm.getClient();
//Delivery delivery = orderForm.getDelivery();
//CakeClient cakeClient = orderForm.getCakeClient();
//order.setDelivery(delivery);
//order.setClient(client);
//Optional<Cake> cake = cakeService.getCakeFindById(id);
//
//cakeClient.setDescriptionCake(cake.get().getDescriptionCake());
//cakeClient.setNameCake(cake.get().getNameCake());
//cakeClient.setUrlImageCake(cake.get().getUrlImgCake());
//
//order.setCake(cakeClient);
//        System.out.println(cake);
//        System.out.println(order);
//orderService.save(order);
//return "redirect:/choice";
//    }
//    @PostMapping("/create")
//    public String createCakeProba(@RequestParam("file")MultipartFile file, CakeProba cakeProba)throws IOException {
//       cakeProbaService.saveCakeProba(cakeProba,file);
//return "redirect:/";
//    }
//
//    @GetMapping("/{id}")
//    public String cakeInfo(@PathVariable int id,Model model){
//        CakeProba cakeProba = cakeProbaService.getCakeProbaById(id);
//        model.addAttribute("cakeProba" ,cakeProba);
//        model.addAttribute("images",cakeProba.getImages());
//        return "admin-choice";
//    }
}
