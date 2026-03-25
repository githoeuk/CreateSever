package http.toJson;

import com.google.gson.Gson;

public class ToJsonUser {
    // User 객체를 생성해서 -> JSON 문자열로 변환하기
    public static void main(String[] args) {

        // 각 객체를 외부 클래스로 뽑던가
        // 내부 클래스로 static을 사용하는 방법을 많이 이용한다.

        User user = new User();
        User.Address address = new User.Address(); // 내부 클래스 선언
        User.Address.Geo geo = new User.Address.Geo();
        User.Company company = new User.Company();

        user.setId(1);
        user.setName("홍길동");
        user.setEmail("Hongkilldong@gmail.com");
        user.setAddress(address);
        address.setStreet("Killdong");
        address.setSuite("idn");
        address.setCity("Busan");
        address.setZipCode("집코드");
        user.getAddress().setGeo(geo);
        geo.setLat("-2134");
        geo.setLng("+1234");
        user.setPhone("01048019790");
        user.setWebsite("Tistory");
        user.setCompany(company);
        company.setName("KilldongCompany");
        company.setCatchPhrase("idk");
        company.setBs("Boss..?");

        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        System.out.println(userJson);

    } // end of main

} // end of class
