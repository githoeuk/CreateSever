package java_oop.Collections;

import lombok.*;

@Data // getter ,setter , 생성자(기본 생성자) , ToString 전부 자동 생성
@AllArgsConstructor //모든 변수가 들어가있는 생성자

public class Member {

    // 회원 정보 요구사항
    private int id;
    private String name;
    private String email;
    private int age;

    // 생성자 직접 생성도 가능

    public Member(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

} // end of class
