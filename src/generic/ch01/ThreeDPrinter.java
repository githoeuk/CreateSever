package generic.ch01;

public class ThreeDPrinter {

    // 재료
    Object material;

    // 재료 꺼냄
    public Object getMaterial(){
        return material;
    }

    // 재료 넣기
    public void setMaterial(Object material){
        this.material = material;
    }


    public static void main(String[] args) {

        Plastic plastic = new Plastic();
        Powder powder = new Powder();
        ThreeDPrinter threeDPrinter = new ThreeDPrinter();

        threeDPrinter.setMaterial(plastic);
        System.out.println(threeDPrinter.getMaterial());
        System.out.println("----------------------");

        threeDPrinter.setMaterial(powder);
        System.out.println(threeDPrinter.getMaterial());
        System.out.println("----------------------");

        // 타입을 선언해서 저장시켜 보자
        // 코드의 흐름을 보면 현재 threeDPrinter에는 powder가 들어가있음
        Powder tempPlastic = (Powder) threeDPrinter.getMaterial();
        // 데이터 타입을 강제로 바꾸면 런타임 시점에서 에러가 발생함
        //Plastic tempPlastic = (Plastic) threeDPrinter.getMaterial();


        System.out.println("프로그램을 종료 합니다.");
    }

}
