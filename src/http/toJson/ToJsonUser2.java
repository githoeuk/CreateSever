package http.toJson;

public class ToJsonUser2 {

    public static void main(String[] args) {

        User2 user2 = new User2();
        User2.Address address = new User2.Address();
        User2.Address.Geo geo = new User2.Address.Geo();
        User2.Company company = new User2.Company();

        user2.setAddress(address);
        user2.getAddress().setGeo(geo);
        user2.setCompany(company);

    } // end of main

} // end of mainClass
