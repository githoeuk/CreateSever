package http.gson;

// https://jsonplaceholder.typicode.com/posts/1


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

    // 단건 조회 -> 여러건 조회 TypeToken 이용

public class PostClient2 {

    public static void main(String[] args) {

        String urlString = "https://jsonplaceholder.typicode.com/posts";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseHttpCode = connection.getResponseCode();
            System.out.println("통신 성공 여부 확인 : " + responseHttpCode);

            // 조회 출력

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                StringBuffer responseBody = new StringBuffer();
                String line;
                while ((line = reader.readLine())!=null){
                    responseBody.append(line);
                }

                String jsonString = responseBody.toString();

                Gson gson = new Gson();
                TypeToken<List<Post>> typeToken = new TypeToken<>(){};
                List<Post> postList = gson.fromJson(jsonString,typeToken.getType());

                System.out.println("전체 개수 : "+ postList.size());

                for (int i = 0; i < 3; i++) {
                    System.out.println(postList.get(i));
                }
            }

        } catch (Exception e) {
            System.out.println("통신 실패 : " + e.getMessage());
        }


    } // end of main

} // end of class
