package http.toJson;

import com.google.gson.Gson;

public class ToJsonUser {
    // User 객체를 생성해서 -> JSON 문자열로 변환하기
    public static void main(String[] args) {

        // 각 객체를 외부 클래스로 뽑던가
        // 내부 클래스로 static을 사용하는 방법을 많이 이용한다.

        User user = new User();
        //User.Address address = user.new Address(); // 내부 클래스 선언
        //User.Address.Geo geo = user.address.new Geo();
        //User.Company company = user.new Company();

        user.setId(1);
        user.setName("홍길동");
        user.setEmail("Hongkilldong@gmail.com");
        user.address.setStreet("Killdonglee");
        user.address.setSuite("idn");
        user.address.setCity("Busan");
        user.address.setZipCode("집코드");
        user.address.geo.setLat("-2134");
        user.address.geo.setLng("+1234");
        user.setPhone("01048019790");
        user.setWebsite("Tistory");
        user.company.setName("KilldongCompany");
        user.company.setCatchPhrase("idk");
        user.company.setBs("Boos..?");

        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        System.out.println(userJson);

    } // end of main

} // end of class
