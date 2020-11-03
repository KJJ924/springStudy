package study.spring.springmvc.controller.beautyshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.spring.springmvc.dto.beautyShop.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BeautyShopController {
    @GetMapping("/test")
    public String showTest(){
        return "/beautyShop/menu";
    }

    @PostMapping("/test")
    public String manyParam(@RequestParam("menu_title")List<String> menuTitleList,
                            @RequestParam("menu_price")List<Integer> menuPriceList){
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<menuPriceList.size(); i++){
            map.put(menuTitleList.get(i),menuPriceList.get(i));
        }
        Menu menu = new Menu();
        menu.setMenu(map);
        System.out.println(map);
        return "test";
    }

}
