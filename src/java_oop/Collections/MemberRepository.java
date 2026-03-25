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
    public boolean save(String name, String email, int age) {

        // 이메일 중복 확인
        if (emailSet.contains(email)) {
            System.out.println("[오류] 이미 사용중인 이메일입니다." + email);
            return false;
        } // end of if

        Member member = new Member(nextId, name, email, age);
        memberList.add(member);
        memberMap.put(nextId, member);
        emailSet.add(email);

        nextId++;

        System.out.println("[완료] 회원 가입 : " + member.getName());
        return true;
    } // end of save

    // ID로 회원 조회
    // ID로 회원 조회 - 1(입력) --> 반환 (Member)
    public Member findById(int id) {

        if(memberMap.get(id).equals(null)){
            System.out.println("아이디가 존재하지 않거나 틀렸습니다");
        }

        return memberMap.get(id);
    } // findById

    // 전체 회원 목록 조회
    // 받아야 할 정보... -> 없음 - 모든 Member정보 리턴 -> list 사용
    public List<Member> findAll() {
        return memberList;
    } // end of findAll

    // 이름으로 회원 조회 하는 기능
    // 필요조건 - 이름 - 반환타임 - ListMember
    public List<Member> findByName(String name) {

        List<Member> result = new ArrayList<>();
        // 전체 조회
        for (Member member : memberList) {
            if (member.getName().equals(name)) {
                result.add(member);
            } // end of if
        } // end of for

        return result;
    } // end if findByName

    // 전체 회원 수
    public int count() {
        return memberList.size();
    } // end of count

    // 회원 ID번호로 삭제
    public boolean delete(int id) {
        // 조회 후 삭제
        Member member = memberMap.get(id);
        if (member == null) {
            System.out.println("존재하지 않는 회원입니다. ID : " + id);
            return false;
        } // end of if
        // list, map, set - 동기화 처리 중요
        memberList.remove(id - 1); // 인덱스 번호로 삭제함
        memberMap.remove(id);
        emailSet.remove(member.getEmail());

        System.out.println("정상적으로 삭제되었습니다" + member.getEmail());
        return true;

    } // end of deletes

    // 회원 정보 수정
    // 1. id기준으로 회원 정보 조회
    // 2. 새로운 이름 정보 필요
    // 3. 새로운 나이 정보 필요
    // 4. 이메일은 중복 처리때문에 수정 불가 처리
    public boolean update(int id, String newName, int newAge) {
        // 수정을 할려면 먼저 조회를 해야 함
        Member member = memberMap.get(id);
        if (member == null) {
            System.out.println("존재하지 않는 회원입니다. ID : " + id);
            return false;
        } // end of if
        member.setName(newName);
        member.setAge(newAge);
        System.out.println("[완료] 수정됨 : " + member);
        return true;
    } // end of update

    // 나이 범위 검색
    // 입력 데이터 minAge,maxAge
    public List<Member> findByAgeRange(int minAge, int maxAge) {

        List<Member> result = new ArrayList<>();
        for (Member member : memberList) {
            if (member.getAge() >= minAge && member.getAge() <= maxAge) {
                System.out.println(member);
                ;
            }
        } // end of for

        if (result.equals(null)) {
            System.out.println("범위에 해당하는 회원이 없습니다.");
        }

        //System.out.println(result);
        return result;

    }// end of findByAgeRange

    public Member findByEmail(String email) {


        for (int i = 0; i < memberList.size(); i++) {

            Member member = memberList.get(i);
            if (member.getEmail().equals(email)) {

                System.out.println("결과 : " + member);
                return member;
            }

        } // end of for

        System.out.println("찾으시는 이메일이 없습니다.");
        return null;
    } // end of findByEmail


}  // end of class
