package study.spring.springmvc.dto.member;

import study.spring.springmvc.controller.MemberController.SignUpController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// Model(Business Logic)
public class Member {

    private Long DB_ID;
    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @NotEmpty
    private String pw;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    @Min(1)
    private String age;

    private Role role;

    public Member( @NotNull @NotEmpty String id, @NotNull @NotEmpty String pw, @NotNull @NotEmpty String name
            , @NotNull @NotEmpty @Min(1) String age,Role role) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
