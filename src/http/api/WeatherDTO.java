package http.api;

import lombok.Data;

import java.util.List;

@Data
public class WeatherDTO {

    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private String name;
//    private Coord coord;
//    private Rain rain;
//    private Clouds clouds;
//    private Sys sys;


    @Data
    public static class Weather {
        private String description;
    } // end of 상태

    @Data
    public static class Main {
        private float temp;
        private int humidity;
    } // end of 기온 , 습도

    @Data
    public static class Wind {
        private float speed;
    } // end of 풍속


//    @Data
//    public static class Coord {
//    }
//
//    @Data
//    public static class Rain {
//    }
//
//    @Data
//    public static class Clouds {
//    }
//
//    @Data
//    public static class Sys {
//    }


} // end of mainClass
