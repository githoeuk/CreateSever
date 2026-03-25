package http.pashing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    int id;
    String name;
    String email;
    Address address;
    String phone;
    String website;
    Company company;

    @Data
    class Address {
        String street;
        String suite;
        String city;
        String zipCode;
        Geo geo = new Geo();

        @Data
        class Geo {
            String lat;
            String lng;
        }
    }

    @Data
    class Company {
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