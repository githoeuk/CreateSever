package generic.ch03;

/*
    < T extends 클래스 > 를 사용하면 현재 코드에서
    Material를 상속받는 자식클래스만 들어 올 수 있다.
 */

// 제네릭 상속
public class GenericExtendsPrinter<T extends Material> {

    T material;

    public T getMaterial(){
        return material;
    }

    public void setMaterial(T material){
        this.material = material;
    }



}
