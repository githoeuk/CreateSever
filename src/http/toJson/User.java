package http.toJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    private int id;
    private String name;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;


    @Data
    static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipCode;
        private Geo geo;

        @Data
        static class Geo {
            private String lat;
            private String lng;
        }
    } // end of Address

    @Data
    static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    } // end of Company

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