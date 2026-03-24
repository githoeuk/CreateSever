package java_oop.Collections.Ex;

import java.util.*;

public class MemberRepository {

    // 멤버를 저장할 콜렉션들
    private List<Member> memberList = new ArrayList<>(); // 전체 목록
    private Map<Integer, Member> memberMap = new HashMap<>(); // ID -> 회원 정보
    private Set<String> eamilSet = new HashSet<>(); // 이메일 중복 체크

    // 회원 가입 시 ID를 자동으로 1씩 증가 할당
    private int nextId;

    // 회원 가입
    public boolean save(String name, String email, int age) {

        // 이메일 중복 확인
        if (eamilSet.contains(email)) {
            System.out.println("[오류] 이미 사용중인 이메일입니다.");
            return false;
        } // end of if

        Member member = new Member(nextId, name, email, age);
        memberList.add(member);
        memberMap.put(nextId, member);
        eamilSet.add(email);

        nextId++;
        System.out.println("[완료] 회원 가입 : " + member.getName());
        return true;
    } // end of save

    // Id로 회원 조회
    public Member FindById(int id){
        return memberMap.get(id);
    }

    // 전체 회원 조회
    public List<Member>findAll(){
        return memberList;
    }

    // 이름으로 회원 조회
    public List<Member> findByName(String name){
        List<Member> result = new ArrayList<>();
        // 전체 조회
        for(Member member : memberList){
            if(member.getName().equals(name)){
                result.add(member);
            } // end of if
        } // end of ofr
        return result;
    } // end oof FindBYName

    // 전체 회원 수 출력
    public int count(){
        return memberList.size();
    } // end of count

    public boolean delete(int id){
        Member member = memberMap.get(id);
        if(member == null){
            System.out.println("존재하지 않는 회원입니다. ID : " + id);
            return false;
        } // end of if
        // list, map , set - 동기화 처리
        memberList.remove(id);
        memberMap.remove(id);
        eamilSet.remove(member.getEmail());

        System.out.println("정상적으로 삭제되었습니다. " + member.getEmail());
        return true;
    } // end of deletes

    // 회원 정보 수정
    public boolean update(int id, String newName, int newAge){
        Member member = memberMap.get(id);
        if(member == null){
            System.out.println("존재하지 않는 id입니다 : " + id);
            return false;
        }
        member.setName(newName);
        member.setAge(newAge);
        return true;
    }

    // 나이 범위 검색
    public List<Member> findByAgeRange(int min , int max){

        List<Member> result = new ArrayList<>();
        for(Member member : memberList){
            if (member.getAge() <= max && member.getAge() >= min){
                System.out.println(member);
                result.add(member);
            }
        }
        if(result.equals(null)){
            System.out.println("조건에 맞는 회원이 없습니다.");
        }
        return null;
    }

    // 이메일로 회원 찾기



} // end of class
