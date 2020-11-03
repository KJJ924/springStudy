package study.spring.springmvc.dto.beautyShop;

import java.util.Map;

public class Menu {
    //pk
    private Long DB_id;
    //fk
    private Long shopDB_id;
    // String -> 파마,컷트,등등  Integer -> 가격
    private Map<String ,Integer> menu;

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Integer> menu) {
        this.menu = menu;
    }
}
