package http.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AirClient {

    private static final String SERVICE_KEY = "jyJa2AAUPguSGTKw0W%2FzxyJJk1eAuscs%2BoB2hJXL3L7hUXws37pE1oskXXRfK%2BDNr3URyHPT04mE5lupzhHOXA%3D%3D";
    private static final String BASE_URL = "http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo";

    public static void main(String[] args) {

        try {



            URL url = new URL(SERVICE_KEY);
            HttpURLConnection connection;
            connection = (HttpURLConnection) url.openConnection();

            int responseHttpCode = connection.getResponseCode();
            System.out.println("응답 확인 : " + responseHttpCode);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    } // end of main

    private static String getAirData() {


        return " ";
    } // end of getAirData
} // end of main
