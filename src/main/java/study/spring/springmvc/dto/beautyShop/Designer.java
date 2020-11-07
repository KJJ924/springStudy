package study.spring.springmvc.dto.beautyShop;

import java.util.List;

public class Designer {
    private Long id;
    private String name;
    private String specialty;
    //one to many 관계
    private List<Order> orders;
    //many to one 관계
    private BeautyShop beautyShop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public BeautyShop getBeautyShop() {
        return beautyShop;
    }

    public void setBeautyShop(BeautyShop beautyShop) {
        this.beautyShop = beautyShop;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", orders=" + orders +
                ", beautyShop=" + beautyShop +
                '}';
    }
}
