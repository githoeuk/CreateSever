package java_oop.Collections.set;

import java.util.*;

public class LottoGame {

    public static void main(String[] args) {
        Set<Integer> lotto = new HashSet<>();
        Random random = new Random();

        // 6개 번호가 될때까지 계속 추가
        while (lotto.size() < 6) {

            int number = random.nextInt(45) + 1;
            lotto.add(number);

        } // end of while

        System.out.println("이번 주 로또 번호 : " + lotto);
        System.out.println("총 " + lotto.size() + "개");

        // 로또 번호를 오름 차순으로 정렬하시오.
        // 한트 - 배열이나 list 계열은 순서가 있음
        // Arraylist 생성자 안에 set 계열을 넣으면 자동으로 Arraylist 객체를 생성해 준다.
        List<Integer> sortedLotto  = new ArrayList<>(lotto);

        // 오름차순 정렬
        Collections.sort(sortedLotto);
        System.out.println("번호 오름차순 : " + sortedLotto);



    } // end of main


} // end of class
