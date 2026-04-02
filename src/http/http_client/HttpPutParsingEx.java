package http.http_client;


// 기존 데이터를 수정(PUT)하고, 수정된 결과를 객체로 파싱하여 확인해보자

import com.google.gson.Gson;
import http.http_client.Dtos.Post;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPutParsingEx {

    // https://jsonplaceholder.typicode.com/posts/1

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient(); // 객체 생성 및 주소 참소
        Gson gson = new Gson();

        // 통신을 요청하는 코드에서는 거의 대부분 예외처리를 해주어야 한다.
        try {
            Post updatePost = Post.builder()
                    // sql - where 절 구문
                    .id(1)
                    .title("수정할 제목")
                    .body("수정할 내용")
                    .userId(10) // 인증 검사 - 올바른 사용자인지 확인
                    .build();
            // 직렬화 - json문자열로 변환
            String jsonRequest = gson.toJson(updatePost);

            // HTTP 요청 메세지 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                    .header("Content-Type", "application/json")
                    // 서버측으로 보낼 타입을 명시해야 한다.(Http바디영역)
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            // 서버측으로 요청 전송 및 응답
            // 1 번째 인수값 : 내가 만들어 둔 HTTP 요청 메세지 객체
            // 2 번째 인수값 : 서버가 보내준 데이터를 어떤 형태로 받을 것인가 명시(String)
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // response(HttpResponse)에 응답을 담음
            System.out.println("response : " + response);
            System.out.println("response 응답 코드 : " + response.statusCode());

            if (response.statusCode() == 200) {
                System.out.println("통신 성공");
                System.out.println("response Body : " + response.body());
                Post resultPost = gson.fromJson(response.body(), Post.class);

                System.out.println(resultPost.getId());
                System.out.println(resultPost.getBody());

            } else {
                System.out.println("잘못된 요청 또는 응답");
            } // end of if-else


        } catch (Exception e) {
            throw new RuntimeException(e);
        } // end of try


    } // end of main


} // end of class
