package http.api;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {

    public static void main(String[] args) {
        String apiKey = "48f17fd9e73e60977fa6d8246d59eb27"; // 발급받은 API 키 입력
        String city = "Busan";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric&lang=kr";

        try {
            // 1. URL 객체 생성 및 연결 설정
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000); // 연결 타임아웃 5초
            conn.setReadTimeout(5000);    // 읽기 타임아웃 5초

            // 2. 응답 코드 확인 (200 OK 인지 체크)
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                // 3. 입력 스트림을 통해 데이터 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                BufferedReader rd;
                if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } else {
                    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                }

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    sb.append(line);
                }
                String jsonString = response.toString();

                // 4. 결과 출력
                System.out.println("응답 성공!");
                System.out.println(conn.getResponseCode());
                //System.out.println(jsonString);

                conn.disconnect();
                in.close();

                // 객체 변환

                Gson gson = new Gson();
                WeatherDTO weatherDTO = gson.fromJson(jsonString, WeatherDTO.class);
                System.out.println("도시 : " + weatherDTO.getName());
                System.out.println("상태 : " + weatherDTO.getWeather().get(0).getDescription());
                System.out.println("기온 : " + weatherDTO.getMain().getTemp() + "C");
                System.out.println("습도 : " + weatherDTO.getMain().getHumidity() + "%");
                System.out.println("풍속 : " + weatherDTO.getWind().getSpeed() + "m/s");

            } else {
                System.out.println("호출 실패. 응답 코드: " + responseCode);
            }

            // 도전 문제 1 - 파싱 처리

            // 출력 값
            // 상태 : 맑음
            // 기온 :
            // 습도  :
            // 풍속 :

            // 간단한 날씨 알림 로직
            // 25도 이상 날씨 - 더움
            // 25도 이하 날씨 - 쌀쌀


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
