package java_oop.Collections;

import java.util.List;
import java.util.Scanner;

// 메인에서 실행해보기
public class MemberMain {

    public static void main(String[] args) {
        MemberRepository repo = new MemberRepository();
        Scanner sc = new Scanner(System.in);

        //SampleData
        Member member1 = new Member("홍길동1", "a@naver.com", 10);
        Member member2 = new Member("홍길동12", "ab@naver.com", 12);
        Member member3 = new Member("홍길동123", "abc@naver.com", 14);
        Member member4 = new Member("홍길동1234", "abcd@naver.com", 16);

        repo.save(member1.getName(), member1.getEmail(), member1.getAge());
        repo.save(member2.getName(), member2.getEmail(), member2.getAge());
        repo.save(member3.getName(), member3.getEmail(), member3.getAge());
        repo.save(member4.getName(), member4.getEmail(), member4.getAge());

        //repo.findByAgeRange(9, 12);
        //repo.findByEmail("bc@naver.com");

        while (true) {
            System.out.println("\n=== 회원 관리 시스템 ===");
            System.out.println("전체 회원: " + repo.count() + "명");
            System.out.println("1. 회원 가입");
            System.out.println("2. ID 로 조회");
            System.out.println("3. 이름으로 조회");
            System.out.println("4. 회원 수정");
            System.out.println("5. 회원 삭제");
            System.out.println("6. 전체 목록");
            System.out.println("7. 나이 범위로 찾기");
            System.out.println("8. 이메일로 회원 찾기");
            System.out.println("0. 종료");
            System.out.print("선택 : ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("이름  : ");
                String name = sc.nextLine();
                System.out.print("이메일 : ");
                String email = sc.nextLine();
                System.out.print("나이  : ");
                int age = Integer.parseInt(sc.nextLine());
                // 유효성 체크 -- 메모리나 DB안에 들어가는 데이어들을 무결성을 위해
                // 앞에서 뒤에서 들어오는 데이터가 유효한지 체크 하는 코드를 반드시 작성해야 한다.
                repo.save(name.trim(), email.trim(), age);

            } else if (choice.equals("2")) {
                System.out.print("조회할 ID : ");
                int id = Integer.parseInt(sc.nextLine());
                Member member = repo.findById(id);
                if (member != null) {
                    System.out.println("조회 결과: " + member);
                } else {
                    System.out.println("해당 회원이 없습니다.");
                }

            } else if (choice.equals("3")) {
                System.out.print("조회할 이름 : ");
                String name = sc.nextLine();
                List<Member> result = repo.findByName(name);
                if (result.isEmpty()) {
                    System.out.println("해당 이름의 회원이 없습니다.");
                } else {
                    for (Member m : result) {
                        System.out.println(m);
                    }
                }

            } else if (choice.equals("4")) {
                System.out.print("수정할 ID : ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("새 이름   : ");
                String newName = sc.nextLine();
                System.out.print("새 나이   : ");
                int newAge = Integer.parseInt(sc.nextLine());
                repo.update(id, newName, newAge);

            } else if (choice.equals("5")) {
                System.out.print("삭제할 ID : ");
                int id = Integer.parseInt(sc.nextLine());
                repo.delete(id);

            } else if (choice.equals("6")) {
                System.out.println("\n=== 전체 회원 목록 ===");
                List<Member> all = repo.findAll();
                if (all.isEmpty()) {
                    System.out.println("등록된 회원이 없습니다.");
                } else {
                    for (Member m : all) {
                        System.out.println(m);
                    }
                }

            } else if (choice.equals("7")) {
                System.out.print("최소 나이를 입력하세요 : ");
                int min = sc.nextInt();
                System.out.print("최대 나이를 입력하세요 : ");
                int max = sc.nextInt();
                repo.findByAgeRange(min, max);

            } else if (choice.equals("8")) {
                System.out.print("찾으시는 회원의 이메일을 입력하세요 : ");
                String findEmail = sc.nextLine();
                repo.findByEmail(findEmail.trim());

            } else if (choice.equals("0")) {
                System.out.println("시스템을 종료합니다.");
                break;

            }


        }

    } // end of main
} // end of class
