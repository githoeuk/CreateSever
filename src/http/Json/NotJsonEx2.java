package http.Json;

public class NotJsonEx2 {
    public static void main(String[] args) {
        String json = "{\"userId\": 1,\"id\": 1,\"title\": \"quidem molestiae enim\"}";
        // json 형식의 문자열을 파싱해서 Album 객체로 변환해 보자.

        // 1. 괄호 제거
        String step1 = json.replace("{" , "").replace("}","");
        // System.out.println(step1);
        // 2. 쉼표 제거
        String[] parts1 = step1.split(",");
        // System.out.println(parts1.toString());
        // 3. userid 추출
        String userString = parts1[0].split(":")[1];
        int userValue = Integer.parseInt(userString.trim());
        //System.out.println(userValue);
        // 4. id 추출
        String idString = parts1[1].split(":")[1];
        int idValue = Integer.parseInt(idString.trim());
        //System.out.println(idValue);
        // 5. title 추출
        String titleValue = parts1[2].split(":")[1];
        //System.out.println(titleValue);

        Album album = new Album(userValue,idValue,titleValue);
        System.out.println(album.toString());


    } // end of main
} // end of class

