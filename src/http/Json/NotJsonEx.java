package http.Json;

public class NotJsonEx {
    public static void main(String[] args) {

        // HTTP 통신으로 json 형식 데이터를 받았다고 가정
        // json 형식은 자바에서 문자열 취급
        String json = "{\"nama\" : \" 철수\" , \"age\": 25}";

        // 위 json 형식에 문자열을 우리 프로그램 내에서 사요을 하려면 파싱 처리를 해야 한다.
        // 1단계 : 불필요한 기호 제거 (replace 사용)
        // 중괄호와 큰 따옴표 아무것도 없는 상태("")로 만들어 본다.
        String step1 = json.replace("{","").replace("}","");
        System.out.println(step1); // 중괄호 탈락

        // 2단계 : 항목별 자르기 (split 사용)
        String[] parts = step1.split(","); // 쉼표 기준으로 자르기
        System.out.println("Size L " + parts.length);
        System.out.println(parts[0]);
        System.out.println(parts[1]);

        // 3단계 : 데이터 추출 및 할당
        // 첫번째 조각에서 " name " : " 철수 " - 철수라는 값만 추출
        // " : " 을 기준으로 추출
        String nameValue = parts[0].split(":")[1]; // 철수를 1번째에 담음
        System.out.println(nameValue);

        // 두번쨰 조각에서 "age" : 25에서 25를 추출
        //
        String ageString = parts[1].split(":")[1];
        System.out.println(ageString);
        // 형변환
        int ageValue = Integer.parseInt(ageString.trim());
        System.out.println(ageValue);

        // 3.5 User클래스 및 생성자 생성

        // 4단계 : 자바 프로그램에서 이해하는 데이터 타입 -> 객체로 변환
        // -> 객체 생성
        User user = new User(nameValue, ageValue);


    } // end of main

} // end of class

class User{

    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString();
    }
} // end of user