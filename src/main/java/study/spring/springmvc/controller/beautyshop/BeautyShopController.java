package study.spring.springmvc.controller.beautyshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;
import study.spring.springmvc.service.BeautyShopService.BeautyShopService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@SessionAttributes({"shop"})
public class BeautyShopController {
    private BeautyShopService beautyShopService;

    @Autowired
    public BeautyShopController(BeautyShopService beautyShopService) {
        this.beautyShopService = beautyShopService;
    }

    @GetMapping("/test")
    public String showTest(){
        return "/beautyShop/menu";
    }

    @GetMapping("/beautyShopList")
    public String beautyShopList(Model model){
        List<BeautyShop> beautyShops = beautyShopService.getBeautyShops();
        model.addAttribute("shops",beautyShops);
        return "/beautyShop/beautyShopList";
    }

    @PostMapping("/beautyShopList")
    public String beautyShopListAfterOrder(Model model, @RequestParam(name="beautyShopId") Long beautyShopId,
                                           @RequestParam(name="designerId") Long designerId,
                                           @RequestParam(name="menuPrice") int menuPrice,
                                           @RequestParam(name="reservationDate") LocalDateTime reservationDate){

        // service에서 order 나머지값들 세팅(저장) 한뒤 리스트로 다시 복귀
        return "redirect:/beautyShop/beautyShopList";
    }

    @GetMapping("/beautyShopOrder")
    public String beautyShopOrder(){

        return "/beautyShop/beautyShopOrder";
    }

    @GetMapping("/beautyShopDetailPage")
    public String beautyShopDetailPage(@RequestParam(name="id") Long beautyDB_id, Model model){
        BeautyShop beautyShop = beautyShopService.getBeautyShop(beautyDB_id);
        List<Designer> designerList = beautyShopService.getDesignerList(beautyShop.getStoreName());
        Map<String, Integer> menuMap = beautyShopService.getMenu(beautyShop.getStoreName());
        Menu menu = new Menu();
        menu.setMenu(menuMap);
        beautyShop.setDesignerList(designerList);
        beautyShop.setMenu(menu);
        /*Map<String,Object> modelMap = new HashMap<>(){
            {
                put("shops",beautyShop);
                put("designerList",designerList);
                put("menu",menu);
            }
        };*/
        // 위에 처럼 맵으로 담아서 model 에 넘겨주는데 jsp 에서 어떻게 가져다가 써요? ㅎㅎ
        // 방법 찾고 -> jsp 에 뿌려주세여
        // 맵으로 한이유 ->  일일이 하나씩 model.addAttribute 해도 되는데 그러면 중복코드 3번 생김
//        model.addAttribute("BeautyShopMap",modelMap);
        model.addAttribute("beautyShop",beautyShop);
        return "/beautyShop/beautyShopDetailPage";
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

        // 서비스 ->shop 넘겨주면 알아서 shop 있는 객체들 나뉘어서 저장하는 흐름으로 개발.
        beautyShopService.saveFactoryBeautyShopService(shop);

        return "beautyShop/createResultPage";
    }
    @GetMapping("/registerDesigner")
    public String registerDesignerForm(){
        return "beautyShop/designer";
    }

    /*2020-11-06 컨트롤분석하세여 ㅋㅋ
        중첩커맨드객체 로 받으면됨 위에 하지마세요 (JSP 참조)
        designer.jsp 참고하여 확인하였음.
         */
    @PostMapping("/registerDesigner")
    public String createDesigner(@ModelAttribute BeautyShop getOnlyDesignerList,
                                 @SessionAttribute("shop") BeautyShop shop ){
        // ModelAttribute 명시가 아무것도 안되있는데 리스트로 받아온건가??
        // -> 폼에서보내는 name에 명시된 프로퍼티명과 VO 객체의 프로퍼티명이 같은게 있으면 명시를 따로 안해도 자동으로 바인딩이 됨.
        // 그러면 @RequestParam과 @ModelAttribute의 차이점은?
        // -> @RequestParam
        // 1. 요청 파라미터를 메서드 파라미터에서 1:1로 바인딩 받음.(name같은 파라미터)
        // 2. view에 뿌려질 model을 따로 명시해서 set 해야함.
        // 3. 파라미터를 검증할 수 있는 기능이 없음. (바인딩 도중 예외 발생시 400 에러 를 날리며 예외처리됨.)

        // -> @ModelAttribute
        // 1. 요청 파라미터를 도메인 오브젝트나 DTO(VO?) 요청 파라미터를 바인딩해서 한번에 받는다. (1:1이 아니라 객체단위로 받을때??)
        // 2. 받으면 스프링이 직접 Model에 객체를 넣어주기 때문에 따로 set을 하지않아도 됨.
        // 3. @RequestParam은 예외 발생시 무조건 400 에러를 던지지만 @ModelAttribute는 타입변환에 실패해도 계속 진행된다.
        //    파라미터를 검증할 수 있도록 @ModelAttribute 인자 바로뒤에 BindingResult 라는 인자를 함께 사용하여
        //    입력값 오류에 대한 예외 처리를 컨트롤러에서 처리한다.
        // 추가) ModelAttribute 는 RequestParam보다 먼저 객체 초기화가 이루어지고 인자를 하나씩 매핑하여 바인딩 된다.

        /*임시
         컨트롤러에서 리스트로 받아야하는데 단일객체로밖에 못받음.
         shop에 디자이너를 set하려면 리스트로 set해야하기때문에 중간에 list로 어쩔수없이 add
         객체를 리스트화 한다???*/

//        List<Designer> designerList = new ArrayList<>();

       /*  생각했던거
         그냥 앞단에서 무조건 입력받게 한다고 가정하고 리스트로 다받아옴
         요소 하나씩꺼내서 set 한뒤 리스트에 추가
         그걸 shop에 set
         jsp에서 꺼낸다.
         근데 생각대로안됨.
         오류뜸
         Required List parameter 'speciality' is not present ??*/

        /*
            for(int i=0; i<name.size(); i++){
            designer.setName(name.get(i));
            designer.setSpecialty(speciality.get(i));
            designerList.add(designer);
        }*/
        shop.setDesignerList(getOnlyDesignerList.getDesignerList());
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
