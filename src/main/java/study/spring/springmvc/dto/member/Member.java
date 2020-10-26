package study.spring.springmvc.dto.member;

// Model(Business Logic)
public class Member {
    // getter, setter 세팅
    private String id;
    private String pw;

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
