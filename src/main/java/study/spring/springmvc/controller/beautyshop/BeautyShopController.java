package study.spring.springmvc.controller.beautyshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public String createDesigner(Designer designer, @SessionAttribute("shop") BeautyShop shop, Model model,
                                 @RequestParam List<String> name, @RequestParam List<String> speciality){
        //임시
        // 컨트롤러에서 리스트로 받아야하는데 단일객체로밖에 못받음.
        // shop에 디자이너를 set하려면 리스트로 set해야하기때문에 중간에 list로 어쩔수없이 add
        // 객체를 리스트화 한다???
        List<Designer> designerList = new ArrayList<>();

        // 생각했던거
        // 그냥 앞단에서 무조건 입력받게 한다고 가정하고 리스트로 다받아옴
        // 요소 하나씩꺼내서 set 한뒤 리스트에 추가
        // 그걸 shop에 set
        // jsp에서 꺼낸다.
        // 근데 생각대로안됨.
        // 오류뜸
        // Required List parameter 'speciality' is not present ??
        for(int i=0; i<name.size(); i++){
            designer.setName(name.get(i));
            designer.setSpecialty(speciality.get(i));
            designerList.add(designer);
        }

        shop.setDesignerList(designerList);
        System.out.println(designer);
        model.addAttribute(shop);
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
