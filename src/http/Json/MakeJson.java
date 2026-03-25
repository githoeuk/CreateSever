package http.Json;

public class MakeJson {

    public static void main(String[] args) {

        // 자바 프로그램 -> 서버측
        // 데이터를 보내려면 json 형태의 텍스트를 가장 많이 사용

        Album album = new Album(1,1,"안녕 반가워 나의 앨범이야");
        // {} json Object 형태로 변환해서 보내기

        // 1.
        StringBuffer sb = new StringBuffer();

        sb.append("{"); // 시작 중괄호 추가
        sb.append("\"userId\":").append(album.getUserId()).append(",");
        sb.append("\"id\":").append(album.getId()).append(",");
        sb.append("\"title\":").append("\""+album.getTitle()+"\"");
        sb.append("}"); // 종료 중괄호 추가

        System.out.println(sb.toString());



    } // end of main
} // end of class
