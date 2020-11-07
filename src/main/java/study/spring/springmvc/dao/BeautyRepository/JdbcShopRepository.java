package study.spring.springmvc.dao.BeautyRepository;

import org.springframework.stereotype.Repository;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.beautyShop.Designer;
import study.spring.springmvc.dto.beautyShop.Menu;

import java.util.List;

@Repository
public class JdbcShopRepository implements BeautyShopRepository {
    @Override
    public void designerSave(Designer designer) {

    }

    @Override
    public void beautyShopSave(BeautyShop beautyShop) {

    }

    @Override
    public void menuSave(Menu menu) {

    }

    @Override
    public List<BeautyShop> getAllBeautyShopList() {
        return null;
    }
}
