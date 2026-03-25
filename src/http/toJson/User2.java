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
    AddressEx address;
    String phone;
    String website;
    CompanyEx company;

} // end of User