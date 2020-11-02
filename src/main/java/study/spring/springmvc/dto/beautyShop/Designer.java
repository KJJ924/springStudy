package study.spring.springmvc.dto.beautyShop;

import java.util.List;

public class Designer {

    private String name;
    //one to many 관계
    private List<Order> orders;
    //many to one 관계
    private BeautyShop beautyShop;

}
