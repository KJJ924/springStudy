package study.spring.springmvc.dto.beautyShop;

import java.util.Map;

public class Menu {
    //pk
    private Long DB_id;
    // one to one 관계
    private BeautyShop beautyShop;
    // String -> 파마,컷트,등등  Integer -> 가격
    private Map<String ,Integer> menu;

    public Long getDB_id() {
        return DB_id;
    }

    public void setDB_id(Long DB_id) {
        this.DB_id = DB_id;
    }

    public BeautyShop getBeautyShop() {
        return beautyShop;
    }

    public void setBeautyShop(BeautyShop beautyShop) {
        this.beautyShop = beautyShop;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Integer> menu) {
        this.menu = menu;
    }
}
