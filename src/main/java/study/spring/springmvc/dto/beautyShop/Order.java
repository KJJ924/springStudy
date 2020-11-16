package study.spring.springmvc.dto.beautyShop;

import study.spring.springmvc.dto.member.Member;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private Long shopId;
    private String menuName;
    private Integer price;
    private Long memberId;
    private Long desingerId;
    private LocalDateTime orderDate;
    private boolean cancel;
    private LocalDateTime reservationDate;

    public Order() {
    }

    public Order(Long shopId, String menuName, Integer price, Long memberId, Long desingerId, LocalDateTime orderDate, boolean cancel, LocalDateTime reservationDate) {
        this.shopId = shopId;
        this.menuName = menuName;
        this.price = price;
        this.memberId = memberId;
        this.desingerId = desingerId;
        this.orderDate = orderDate;
        this.cancel = cancel;
        this.reservationDate = reservationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getDesingerId() {
        return desingerId;
    }

    public void setDesingerId(Long desingerId) {
        this.desingerId = desingerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
