package http.gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TodoClient {
    public static void main(String[] args) {

        // 통신할 주소 : https://jsonplaceholder.typicode.com/todos/1
        // 단건 조회 : JSON Object { } 응답 됨

        String urlString = "https://jsonplaceholder.typicode.com/todos/100";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection(); // 소켓 생성

            // HTTP 요청 메시지 만들어서 연결 요청
            connection.setRequestMethod("GET");
            // 수기로 설정하지 않더라도 기본적인 설정이 구축되어 있음

            // 연결 요청
            int responseHttpCode = connection.getResponseCode(); // 통신
            System.out.println("통신 성공 여부 확인 : " + responseHttpCode);

            // 응답 본문 추출
            try (BufferedReader reader = new BufferedReader
                    (new InputStreamReader(connection.getInputStream()))) {

                StringBuffer responseBody =new StringBuffer();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBody.append(line);
                } // end of while
                // StringBuffer -> 문자열로 변경하는 방법 toString()호출 , "" 문자열 더하기
                String jsonString = responseBody.toString();

                System.out.println("Json 응답 : " + responseBody);
                // 자바 프로그램에서 사용하기 위해서는 Json형식 -> 파싱 처리
                // GSON 라이브러리 이용 - 사용 방법
                Gson gson = new Gson();
                // 목적 :자바 객체 <-- json 문자열
                // 변환 하고자하는 json형식의 문자열 <-- 1번쨰 인수 값
                // 변환 하고자하는 DTO타입(클래스) <-- 2번째 인수 값
                Todo todo = gson.fromJson(jsonString,Todo.class); // 짜잔
                // GSON lib를 통해 파싱을 처리하고
                // 자바에서 쓰는 데이터 타입으로 사용가능
                System.out.println("--------------------------------");
                System.out.println(todo.getId());
                System.out.println(todo.getUserId());
                System.out.println(todo.getTitle());
                System.out.println(todo.toString());

            } // end of try

        } catch (Exception e) {
            System.out.println("통신 실패 : " + e.getMessage());
        }


    } // end of main
}
