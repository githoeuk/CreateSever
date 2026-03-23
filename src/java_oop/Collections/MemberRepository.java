package java_oop.Collections;

import java.util.*;

// 역할 - 데이터를 보관하고 관리하는 클래스
public class MemberRepository {


    // 멤버를 저장할
    private List<Member> memberList = new ArrayList<>(); // 전체 목록
    private Map<Integer, Member> memberMap = new HashMap<>(); // ID -> 회원 정보
    private Set<String> emailSet = new HashSet<>(); // 이메일 중복 체크

    // 회원 가입 시 ID를 자동으로 1씩 증가하는 방법으로 회원들에게 할당할 예정
    private int nextId = 1;

    // 회원 가입 (매개변수 : 이름 이메일 나이 )
    public boolean save(String name , String email , int age) {

        // 이메일 중복 확인
        if(emailSet.contains(email)){
            System.out.println("[오류] 이미 사용중인 이메일입니다." + email);
            return false;
        } // end of if

        Member member = new Member(nextId,name,email,age);
        memberList.add(member);
        memberMap.put(nextId , member);
        emailSet.add(email);

        nextId++;

        System.out.println("[완료] 회원 가입 : "+member.getName());
        return true;
    } // end of save

    // ID로 회원 조회
    // ID로 회원 조회 - 1(입력) --> 반환 (Member)
    public Member findById(int id){
        return memberMap.get(id);
    }

    // 전체 회원 목록 조회
    // 받아야 할 정보... -> 없음 - 모든 Member정보 리턴 -> list 사용
    public List<Member> findAll(){
        return memberList;
    }


    // 이름으로 회원 조회 하는 기능
    // 필요조건 - 이름 - 반환타임 - ListMember
    public List<Member> findByName(String name){

        List<Member> result = new ArrayList<>();
        // 전체 조회
        for(Member member : memberList){
            if(member.getName().equals(name)){
                result.add(member);
            } // end of if
        } // end of for

        return result;
    }

    // 회원 정보 수정

    // 회원 삭제

    // 전체 회원 수





} // end of class
