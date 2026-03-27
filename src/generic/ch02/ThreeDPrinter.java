package generic.ch02;

import generic.ch01.Plastic;
import generic.ch01.Powder;

public class ThreeDPrinter {

    // 재료
    Object material;

    // 재료 꺼냄
    public Object getMaterial() {
        return material;
    }

    // 재료 넣기
    public void setMaterial(Object material) {
        this.material = material;
    }


    public static void main(String[] args) {

        generic.ch01.Plastic plastic = new Plastic();
        generic.ch01.Powder powder = new generic.ch01.Powder();
        ThreeDPrinter threeDPrinter = new ThreeDPrinter();

        threeDPrinter.setMaterial(plastic);
        System.out.println(threeDPrinter.getMaterial());
        System.out.println("----------------------");

        threeDPrinter.setMaterial(powder);
        System.out.println(threeDPrinter.getMaterial());
        System.out.println("----------------------");

        // 타입을 선언해서 저장시켜 보자
        // 코드의 흐름을 보면 현재 threeDPrinter에는 powder가 들어가있음

        generic.ch01.Powder tempPowder = (Powder) threeDPrinter.getMaterial();

        // Plastic tempPlastic = (Plastic) threeDPrinter.getMaterial();
        // 컴파일 시점은 코드의 흐름상 문제 없음 , 런타임 시점에서 오류가 발생
        // 현재 threeDPrinter 안에는 Powder 객체가 들어 있다.
        // 따라서 getMaterial()의 반환값을 Powder로 형변환하면 정상 동작한다.
        // 하지만 실제 객체가 Powder인데 Plastic으로 강제 형변환하면
        // 런타임 시점에서 ClassCastException이 발생한다.


        System.out.println("프로그램을 종료 합니다.");
    } // end of main

} // end of class
