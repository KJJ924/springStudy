package study.spring.springmvc.dto.beautyShop;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private Long id;
    private Long shopId;
    private String menuName;
    private Integer price;
    private String memberId;
    private Long designerId;
    private LocalDateTime orderDate;
    private boolean cancel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservationDate;

    public Order() {
    }

    public Order(Long shopId, String menuName, Integer price, String memberId, Long designerId, LocalDateTime orderDate, boolean cancel, Date reservationDate) {
        this.shopId = shopId;
        this.menuName = menuName;
        this.price = price;
        this.memberId = memberId;
        this.designerId = designerId;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
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

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

}
