package study.spring.springmvc.dto.member;

import study.spring.springmvc.controller.MemberController.SignUpController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Model(Business Logic)
public class Member {

    Long DB_ID;
    @NotNull
    @NotEmpty
    String id;
    @NotNull
    @NotEmpty
    String pw;
    @NotNull
    @NotEmpty
    String name;
    @NotNull
    @NotEmpty
    @Min(1)
    String age;

    public Member( @NotNull @NotEmpty String id, @NotNull @NotEmpty String pw, @NotNull @NotEmpty String name, @NotNull @NotEmpty @Min(1) String age) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
    }

    public Member() {
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

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
