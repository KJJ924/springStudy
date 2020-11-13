package study.spring.springmvc.dao.BeautyRepository;

import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

import java.util.List;

public interface BeautyShopRepository {
    void designerSave(List<Designer> designer, BeautyShop shop);
    void beautyShopSave(BeautyShop beautyShop);
    void menuSave(Menu menu);
    List<BeautyShop> getAllBeautyShopList();
    BeautyShop getBeautyShop(Long db_ID);
    List<Designer> getDesignerList(Long Db_id);
    Menu getMenu(Long DB_id);
}
