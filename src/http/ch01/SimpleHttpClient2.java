package http.ch01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleHttpClient2 {

    public static void main(String[] args) {
        // 가짜 서버에 user 10번에 정보를 요청하고 응답을 받고 콘솔창에 출력하시오

        // 통신 주소
        String urlString = "https://jsonplaceholder.typicode.com/users/1";
        // http 통신 클래스
        HttpURLConnection connection = null;

        try {
            // 1단계 : URL 객체 생성
            URL url = new URL(urlString);

            // 2단계 : HTTP 연결 객체 생성 (TCP 소켓 연결 생성 )
            connection = (HttpURLConnection) url.openConnection(); // 소켓 역할 - 다운캐스팅

            // 3단계 : 요청 방식 설정 ( GET, POST, PUT, DELETE)
            // get호출 - 시작줄 , 자원에 요청 -> GET

            connection.setRequestMethod("POST");
            // 헤더
            connection.setRequestProperty("Accept", "application/jon");

            // 4단계 : 실제 요청 전송 --> 서버 --> 즉시 응답 --> (응답 코드)
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 확인 : " + responseCode);
            if (responseCode != 200) { // 200 - 요청 성공
                System.out.println("요청 실패 ");
                return;
            }

            // 5단계 : 응답 본문 읽기
            // I/O 단원에서 배운 체인 그대로 적용하기
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))
            ) {
                // 문자가 많을 떄 StringBuffer 사용
                StringBuffer response = new StringBuffer();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                } // end of while
                System.out.println("응답 내용 :");
                System.out.println(response.toString());
            } // end fo section 5

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main
} // end of class
