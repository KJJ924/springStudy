package study.spring.springmvc.dto.member;

public class Member {
    Long DB_ID;
    String id;
    String pw;
    String name;


    public Long getDB_ID() {
        return DB_ID;
    }

    public void setDB_ID(Long DB_ID) {
        this.DB_ID = DB_ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
