package study.spring.springmvc.controller.beautyshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"shop"})
public class BeautyShopController {
    @GetMapping("/test")
    public String showTest(){
        return "/beautyShop/menu";
    }

    @PostMapping("/test")
    public String manyParam(@RequestParam("menu_title")List<String> menuTitleList,
                            @RequestParam("menu_price")List<Integer> menuPriceList,
                            Model model,
                            SessionStatus status){
        Map<String, Integer> map = new HashMap<>();
        // 코드 개극혐 변경 해야됨
        for(int i=0; i<menuPriceList.size(); i++){
            map.put(menuTitleList.get(i),menuPriceList.get(i));
        }
        BeautyShop shop = (BeautyShop) model.getAttribute("shop");
        Menu menu = new Menu();
        menu.setMenu(map);
        menu.setBeautyShop(shop);
        shop.setMenu(menu);
        System.out.println(shop.getDesignerList());
        status.isComplete();
        model.addAttribute(shop);
        return "beautyShop/createResultPage";
    }
    @GetMapping("/registerDesigner")
    public String registerDesignerForm(){
        return "beautyShop/designer";
    }
    @PostMapping("/registerDesigner")
    public String createDesigner(Designer designers ,@SessionAttribute("shop") BeautyShop shop){
        System.out.println(designers);
        return "redirect:/test";
    }
    @GetMapping("/BeautyShop")
    public String showBeautyShopPage(){
        return "beautyShop/createBeautyShop";
    }
    @PostMapping("/BeautyShop")
    public String createShop(@ModelAttribute BeautyShop shop ,Model model){
        model.addAttribute("shop",shop);
        return "redirect:/registerDesigner";
    }


}
