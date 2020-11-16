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
    private LocalDateTime localDateTime;
    private boolean cancel;

    public Order() {
    }

    public Order(Long shopId, String menuName, Integer price, Long memberId, LocalDateTime localDateTime, boolean cancel) {
        this.shopId = shopId;
        this.menuName = menuName;
        this.price = price;
        this.memberId = memberId;
        this.localDateTime = localDateTime;
        this.cancel = cancel;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
