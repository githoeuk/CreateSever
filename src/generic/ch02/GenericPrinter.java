package generic.ch02;

/*
    제네릭 프로그래밍
    문법 : 클래스 , 테어타임, 메서드 등에서 < T > 대체 문자열을 선언할 수 있다.
 */

public class GenericPrinter<T> {

    // T -- type의 약자 : T or E or K or V ... (사실 아무 의미없는 문자열일 뿐이다.)
    // 자료형 매개변수 (type parameter)
    // 대체 문자 사용 가능

    T material;

    public T getMaterial() {
        return material;
    }


    public void setMaterial(T material){
        this.material = material;
    }

}
