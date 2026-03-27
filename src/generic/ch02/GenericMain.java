package generic.ch02;

import generic.ch01.Plastic;
import generic.ch01.Powder;

public class GenericMain {

    public static void main(String[] args) {
        // 제네릭 프로그래밍을 활용하면 타입에 안정성을 줘서 컴파일 시 (코드 작성시 )
        // 명확하게 타입을 지정할 수 있다.

        Plastic plastic1 = new Plastic();
        Powder powder1 = new Powder();
        Water water1 = new Water();

        // ArrayLsit<Integer>
        // 제네릭을 사용하는 시점에는 무엇을 넣을지 미리 지정해 주어야 한다.
        GenericPrinter<Plastic> genericPrinter = new GenericPrinter();
        // 컴파일 시점에서 플라스틱 타입에 다른 타입을 넣으면 컴파일 오류가 발생한다.
        // genericPrinter.setMaterial(powder);
        genericPrinter.setMaterial(plastic1);
        Plastic tempPlastic = genericPrinter.getMaterial();
        // 컴파일 시점에 타입을 확인 할 수 있고 추가로 다운캐스팅 작업도 필요가 없다.
        // Powder tempPowder = genericPrinter.getMaterial();
        System.out.println("-----------------------------------------");

        // 자료형 매개 변수는 무엇이든 다 담을 수 있지만 이 또한 단점들이 발생할 수 있다.
        GenericPrinter<Water> waterGenericPrinter = new GenericPrinter<>();
        waterGenericPrinter.setMaterial(water1);
        System.out.println(waterGenericPrinter.getMaterial());

        // < T extends 클래스 >
        // 상속을 활용해서 데이터타입을 정제할 수 있다.
        // 


    } // end of main
}
