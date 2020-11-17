package study.spring.springmvc.service.BeautyShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.spring.springmvc.dao.BeautyRepository.BeautyShopRepository;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;
import study.spring.springmvc.dto.beautyShop.Order;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BeautyShopService {
    private final BeautyShopRepository beautyShopRepository;

    @Autowired
    public BeautyShopService(BeautyShopRepository beautyShopRepository) {
        this.beautyShopRepository = beautyShopRepository;
    }

    public void saveOrder(Order order, Long UserDB_id){
        order.setMemberId(UserDB_id);
        order.setOrderDate(LocalDateTime.now());
        beautyShopRepository.orderSave(order);
    }

    // 컨트롤러에서 미용실 save 할라면 이 메서드만 불러주면됨.
    // Service 에서 미용실 다 받은 뒤 여기서 분배
    // shop 을 통쨰로 넘겨서 메서드 내에서 처리하는것이 더 편함.
    public void saveFactoryBeautyShopService(BeautyShop shop) {
        //미용실 객체 저장
        beautyShopRepository.beautyShopSave(shop);
        //디자이너 저장
        saveDesigner(shop);
        // 미용실 메뉴 저장
        saveMenu(shop);
    }

    private void saveDesigner(BeautyShop shop) {
        List<Designer> designerList = shop.getDesignerList();
        beautyShopRepository.designerSave(designerList,shop);
    }

    private void saveMenu(BeautyShop shop) {
        Menu menu = shop.getMenu();
        menu.setBeautyShop(shop);
        beautyShopRepository.menuSave(menu);

    }

    public List<BeautyShop> getBeautyShops() {
        return beautyShopRepository.getAllBeautyShopList();
    }

    public BeautyShop getBeautyShop(Long id){
        // id 에 해당하는 미용실을 리턴헤야함.
        return beautyShopRepository.getBeautyShop(id);
    }

    public List<Designer> getDesignerList(String shopName){
        return beautyShopRepository.getDesignerList(shopName);
    }


    public Map<String,Integer> getMenu(String shopName){
        // 설계 잘못해서 이딴짓 해야됨..
        Map<String,Integer> menuMap = new HashMap<>();
        for (Menu menu : beautyShopRepository.getMenu(shopName)) {
            Map<String, Integer> menu1 = menu.getMenu();
            for(Map.Entry<String, Integer> entry : menu1.entrySet()){
                menuMap.put(entry.getKey(),entry.getValue());
            }
        }
        return menuMap;
    }
}

