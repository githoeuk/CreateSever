package java_oop.Collections.set;

import java.util.HashSet;
import java.util.Set;

public class setEx {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        // 추가
        set.add("철수");
        set.add("영희");
        set.add("철수"); // 중복! -> 무시됨

        System.out.println(set);
        System.out.println(set.size());

        // 포함 여부
        System.out.println(set.contains("철수"));
        System.out.println(set.contains("민준"));


        // set은 인덱스 번호로 삭제 불가
        set.remove("철수");

        // 전체 순회 (Set -> 순서가 없음 -> 기존 for문 사용 불가 )
       for(String name : set){
           System.out.println(name);
       }


    } // end of main
}
