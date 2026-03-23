package java_oop.Collections.map;

import java.util.HashMap;
import java.util.Map;

public class mapEx {

    public static void main(String[] args) {

        // 저장 내용 : 학생이름 , 점수
        // key , value 의 데이터 타입
        Map<String,Integer> scores = new HashMap<>();

        // 추가(put)
        scores.put("철수",90);
        scores.put("영희",86);
        scores.put("민준",92);

        // 조회
        System.out.println(scores.get("철수")); // key값으로 접근 시 value값이 나옴
        System.out.println(scores.get("없는값")); // 값이 없으면 null출력

        // 포함 여부
        System.out.println(scores.containsKey("영희")); // 키 값이 존재한다면 true
        System.out.println(scores.containsValue(86)); // 존재하는 값 = true
        System.out.println(scores.containsValue(10)); // 없는 값 = false

        // 삭제
        scores.remove("민준");
        // 크기
        System.out.println(scores.size());

        // put()  은 덮어씌위기도 한다.
        scores.put("철수",0); // 덮어쓰기 되어버림
        System.out.println(">>>" + scores.keySet()); // 이거는 왜 대괄호로 출력?
        System.out.println(scores); // 중괄호로 출력


        for (String name : scores.keySet()){ // 키값을 꺼내서 set 계열로 변환하여 반복
            System.out.println(name + " : " + scores.get(name) + " 점수");
        } // end of for



    } // end of main
} // end of class
