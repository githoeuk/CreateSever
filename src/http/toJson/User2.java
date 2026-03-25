package http.toJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User2 {

    int id;
    String name;
    String email;
    Address address;
    //Address address = new Address();
    String phone;
    String website;
    Company company;
    //Company company = new Company();

    @Data
    static class Address {
        String street;
        String suite;
        String city;
        String zipCode;
        Geo geo = new Geo();

        @Data
        static class Geo {
            String lat;
            String lng;
        }
    }

    @Data
    static class Company {
        String name;
        String catchPhrase;
        String bs;
    }

} // end of User

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class Address{
//    String street;
//    String suite;
//    String city;
//    String zipCode;
//    Geo geo;
//}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class Geo{
//    String lat;
//    String lng;
//}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class Company{
//    String name;
//    String catchPhrase;
//    String bs;
//}