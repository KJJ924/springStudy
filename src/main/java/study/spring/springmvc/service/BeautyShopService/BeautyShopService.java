package study.spring.springmvc.service.BeautyShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.spring.springmvc.dao.BeautyRepository.BeautyShopRepository;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

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

    // 컨트롤러에서 미용실 save 할라면 이 메서드만 불러주면됨.
    // Service 에서 미용실 다 받은 뒤 여기서 분배
    // shop 을 통쨰로 넘겨서 메서드 내에서 처리하는것이 더 편함.
    public void saveFactoryBeautyShopService(BeautyShop shop){
        //미용실 객체 저장
        beautyShopRepository.beautyShopSave(shop);
        //디자이너 저장
        saveDesigner(shop);
        // 미용실 메뉴 저장
        saveMenu(shop);
    }

    private void saveDesigner(BeautyShop shop){
        List<Designer> designerList = shop.getDesignerList();
        for(Designer designer : designerList) {
            designer.setBeautyShop(shop);
            beautyShopRepository.designerSave(designer);
        }
    }
    private void saveMenu(BeautyShop shop){
        Menu menu = shop.getMenu();
        menu.setBeautyShop(shop);
         beautyShopRepository.menuSave(menu);
        }
    }

