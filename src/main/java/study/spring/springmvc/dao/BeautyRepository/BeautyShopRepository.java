package study.spring.springmvc.dao.BeautyRepository;

import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;
import study.spring.springmvc.dto.beautyShop.Order;

import java.util.List;

public interface BeautyShopRepository {
    void designerSave(List<Designer> designer, BeautyShop shop);
    void beautyShopSave(BeautyShop beautyShop);
    void menuSave(Menu menu);
    void orderSave(Order order);
    List<BeautyShop> getAllBeautyShopList();
    BeautyShop getBeautyShop(Long db_ID);
    List<Designer> getDesignerList(String shopName);
    List<Menu> getMenu(String shopName);

    List<Order> getOrderList(String memberID);
}
