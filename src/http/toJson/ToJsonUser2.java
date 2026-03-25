package http.toJson;

import com.google.gson.Gson;

public class ToJsonUser2 {

    public static void main(String[] args) {

        User2 user = new User2();
        AddressEx address = new AddressEx();
        GeoEx geo = new GeoEx();
        CompanyEx company = new CompanyEx();

        user.setId(1);
        user.setName("홍길동");
        user.setEmail("a@naver.com");
        user.setAddress(address);
        address.setCity("부산");
        address.setStreet("중앙대로");
        address.setZipCode("123");
        user.getAddress().setGeo(geo);
        geo.setLat("123.1");
        geo.setLng("44.5");
        user.setCompany(company);
        company.setBs("123");

        // 객체 --->(직렬화) JSON 텍스트 형식

        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        System.out.println(userJson);



    } // end of main

} // end of mainClass
