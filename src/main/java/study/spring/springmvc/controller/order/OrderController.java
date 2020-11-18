package study.spring.springmvc.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import study.spring.springmvc.dto.beautyShop.Order;
import study.spring.springmvc.service.BeautyShopService.BeautyShopService;

import java.util.List;

@Controller
public class OrderController {
    private final BeautyShopService beautyShopService;

    @Autowired
    public OrderController(BeautyShopService beautyShopService) {
        this.beautyShopService = beautyShopService;
    }

    @PostMapping("/saveOrderData")
    public String beautyShopListAfterOrder(@ModelAttribute Order order,
                                           @SessionAttribute("UserDB_id") String memberID){

        beautyShopService.saveOrder(order, memberID);
        return "redirect:/";
    }

    @GetMapping("/beautyShopOrder")
    public String beautyShopOrder(Model model,
                                  @SessionAttribute("UserDB_id") String memberID){
        List<Order> orderList = beautyShopService.getOrder(memberID);
        model.addAttribute(orderList);

        return "/beautyShop/beautyShopOrder";
    }
}
