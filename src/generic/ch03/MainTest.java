package generic.ch03;

import generic.ch02.Water;

public class MainTest {
    public static void main(String[] args) {

        Water water1 = new Water();
        Plastic plastic1 = new Plastic();
        Powder powder1 = new Powder();

        // GenericExtendsPrinter <-- 제네릭 클래스로 설계되어 있어서 <>를 사용하여 타입을 제한한다.

        //정상
        GenericExtendsPrinter<Powder> printer = new GenericExtendsPrinter<>();
        printer.setMaterial(powder1);
        System.out.println(printer.getMaterial());
        printer.getMaterial().showInfo();
        // System.out.println(printer.getMaterial().showInfo(););

        // 오류 발생 -> Water는 material의 자식이 아니기 때문에 사용할 수 없음
        //GenericExtendsPrinter<Water> printer = new GenericExtendsPrinter();



    } // end of main
}
