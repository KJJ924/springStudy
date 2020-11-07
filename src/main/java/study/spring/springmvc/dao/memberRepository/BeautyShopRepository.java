package study.spring.springmvc.dao.memberRepository;

import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

import java.util.List;

public interface BeautyShopRepository {
    void designerSave(Designer designer);
    void beautyShopSave(BeautyShop beautyShop);
    void menuSave(Menu menu);
    List<BeautyShop> getAllBeautyShopList();
}
