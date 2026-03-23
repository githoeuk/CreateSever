package java_oop.Collections.Ex;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    private int id;
    private String name;
    private String email;
    private int age;
    

    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> emailList = new ArrayList<>();
    ArrayList<Integer> ageList = new ArrayList<>();

    public void create(Scanner sc) {
        System.out.println("== 회원 가입 ==");
        int id = 0;
        idList.add(id);
        id++;
        System.out.print("이름 : ");
        String name = sc.nextLine();
        nameList.add(name);
        System.out.print("이메일 : ");
        String email = sc.nextLine();
        emailList.add(email);
        System.out.print("나이 : ");
        int age = sc.nextInt();
        ageList.add(age);

    } // end of create
    
    public void find(Scanner sc){
        System.out.println("== 회원 조회 == ");
        System.out.print("조회할 회원의 이름이나 이메일을 입력하세요 : ");
        String find = sc.nextLine();
        while (true){
            int i = 0;
            if (find.equals(nameList.get(i))){
                System.out.println();
            }
        }
    }

} // end of class
