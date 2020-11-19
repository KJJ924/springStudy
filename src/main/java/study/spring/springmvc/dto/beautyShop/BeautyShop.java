package study.spring.springmvc.dto.beautyShop;

import study.spring.springmvc.dto.member.Member;

import java.util.List;
import java.util.Map;

public class BeautyShop {
    private Long DB_Id;
    private String storeName;
    private String local;
    private String phoneNumber;
    //one to many 관계
    private List<Designer> designerList;
    //one to many 관계
    private List<Member> memberList;
    //one to one 관계
    private Menu menu;
    public BeautyShop() {
    }

    public BeautyShop(String storeName, String local, String phoneNumber, List<Designer> designerList, List<Member> memberList, Menu menu) {
        this.storeName = storeName;
        this.local = local;
        this.phoneNumber = phoneNumber;
        this.designerList = designerList;
        this.memberList = memberList;
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public Long getDB_Id() {
        return DB_Id;
    }

    public void setDB_Id(Long DB_Id) {
        this.DB_Id = DB_Id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Designer> getDesignerList() {
        return designerList;
    }

    public void setDesignerList(List<Designer> designerList) {
        this.designerList = designerList;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "BeautyShop{" +
                "DB_Id=" + DB_Id +
                ", storeName='" + storeName + '\'' +
                ", local='" + local + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", designerList=" + designerList +
                ", memberList=" + memberList +
                ", menu=" + menu +
                '}';
    }
}
