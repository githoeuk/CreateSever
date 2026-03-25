package http.toJson;

import lombok.Data;

@Data
class AddressEx {
    String street;
    String suite;
    String city;
    String zipCode;
    GeoEx geo;
}
