package java_oop.Collections.Ex;

import java.util.Scanner;

// 메인에서 실행해보기
public class MemberMain{



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();

        while (true){
            System.out.println("=== 회원 관리 시스템 ===");
            System.out.println("1. 회원 가입");
            System.out.println("2. 회원 조회");
            System.out.println("3. 회원 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 전체 목록");
            System.out.println("0. 종료");

            if (choice.equals("1")){

            } else if (choice.equals("2")) {

            }else if (choice.equals("3")) {

            }else if (choice.equals("4")) {

            }else if (choice.equals("5")) {

            }else if (choice.equals("0")) {
                System.out.println("종료합니다");
                break;
            }else {
                System.out.println("다시 입력하세요");
            } // end of if-else

        } // end of while



    } // end of main



} // end of class
