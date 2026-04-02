package http.http_client;

import com.google.gson.Gson;
import http.http_client.Dtos.Post;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPostParsingEx {

    public static void main(String[] args) {

        // 규칙 , 규약
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        // 통신시에는 예외처리가 필요
        try {

            // 자바 객체를 --> 서버측으로 데이터를전달하려면
            // 어떤 과정이 필요한가?
            // --> 문자열로 변환시켜줘야한다(JSON형식의 문자열)


            Post post = Post.builder()
                    .userId(1)
                    .title("HTTP 통신 요청")                                        // 전송할 데이터 제목
                    .body("METHOD 는 POST 요청 데이터를 함께 보내야 함")            // 전송할 내용
                    .build();
            String postSTring = gson.toJson(post); // json형식으로 변환

            // 2. 요청 HTTP 메세지 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/posts")) // uri 링크 정보
                    .header("Content-type", "application/json")       // 받을 데이터 타입
                    .POST(HttpRequest.BodyPublishers.ofString(postSTring))         // 받은 데이터를 문자열로 변환?
                    .build();
            // 3. 실제 전송 및 응답
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // 1. 요청 메세지 2. 받는 메세지 / HttpResponse타입을 문자열제네릭으로 담는다.
            System.out.println(response.toString());
            System.out.println(response.headers()); // http 응답 메세지
            System.out.println(response.body()); // 응답받은 메세지 내용

            // 4. 응답 받은 json파일을 자바에서 사용할 object 형태로 변환해야함 = 파싱(parsing)
            Post createPost = gson.fromJson(response.body(), Post.class);

            // 결과 확인
            System.out.println("----파싱 내용---- ");
            System.out.println(createPost.getId());
            System.out.println(createPost.getUserId());
            System.out.println(createPost.getTitle());
            System.out.println(createPost.getBody());

            // 새로운 리소스(원천데이터)를 서버에 등록할 때
            // 우리는 자바 객체를 한줄로 길게 늘어서 "문자열이나 바이트 배열"
            // 같은 형태로 납작하게 펴준느 과정이 필요한데 이걸 바로 "직렬화"하라고 한다.

            // 서버로부터 JSON 응답을 받아서 다시 JAVA객체로 펴주는 과정 "역직렬화"라고 부른다


        } catch (Exception e) {
            throw new RuntimeException(e);
        } // end of try


    } // end of main
} // end of class
