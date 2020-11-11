package study.spring.springmvc.dao.BeautyRepository;

import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

import java.util.List;

public interface BeautyShopRepository {
    void designerSave(List<Designer> designer);
    void beautyShopSave(BeautyShop beautyShop);
    void menuSave(Menu menu);
    List<BeautyShop> getAllBeautyShopList();
}
