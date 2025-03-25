package ch3.section6_abstract;

interface ITest1 {
    // 인터페이스의 변수 선언 -> 자동으로 public, static, final 추가됨
    int COUNT = 1;
    //  아래처럼 선언한 것과 동일
    public static final int MAX_SIZE = 10;

    // 접근 제한자.. public으로 고정됨
    //private int a = 0; // error
    //protected int b = 10; // error

    void method1();
    // 위 함수는 아래처럼 선언된 것과 동일
    // 자동으로 public, abstract 추가
    public abstract void method2();

    // 구현체를 가지는 함수를 추가하고 싶다면.. default, static, private 중 하나를 선언해야함
    // 구현한 객체에 그대로 상속개념으로 이용!
    default void method3(){
        System.out.println("default function"); // 구현체
        method1(); // 구현체
        method5();
    }

    // 클래스의 static 처럼 이름.함수명...으로 접근
    static void method4(){

    }

    private void method5(){}
}

interface ITest2 {
    void iTest2();
}

interface ITest3 {
    void iTest3();
}

// 인터페이스를 선언하면서 다른 인터페이스를 상속받아 선언 가능
// 인터페이스는 다중 상속이 가능, 인터페이스를 상속받은 인터페이스에서는 오버라이딩 강제가 아님!
// 인터페이스를 구현한 인터페이스가 오버라이딩 강제!!!
interface ITest4 extends ITest2, ITest3{
    void iTest4();
}

abstract class AbstractClass {
    abstract void some1();
}

// ---------------------------------------------------
// 클래스 선언하면서 여러개의 인터페이스 구현 가능
class Sub1 extends AbstractClass implements ITest1, ITest4 {
    @Override
    void some1() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
    // interface에 선언된 default로 선언된 함수를 구현 클래스내에서
    // 오버라이드로 재선언 가능 (필수는 아님) , static, private은 오버라이드 할수 없음
    @Override
    public void method3() {
        ITest1.super.method3();
    }

    @Override
    public void iTest2() {

    }

    @Override
    public void iTest3() {

    }

    @Override
    public void iTest4() {

    }
}

public class Exam2 {
    public static void main(String[] args) {
        // Sub1 + 상속, 구현된거 다 사용가능! => 다형성
        Sub1 obj1 = new Sub1();
        System.out.println(obj1 instanceof Sub1); // true
        // AbstractClass 타입으로 객체를 선언했다면.. AbstractClass에 선언된 멤버만 사용가능!!
        AbstractClass obj2 = new Sub1();
        obj2.some1(); // some1만 가능!! abstractClass만 이용가능하므로!!

        // 인터페이스도 타입으로 이용가능
        // 타입으로만 사용가능! (ITest1만 사용 가능! )
        ITest1 obj3 = new Sub1();
        obj3.method3(); // method3(); 는 default 메서드
        ITest1.method4();  // method4(); 는 static 메서드
        //obj3.method5(); // error - method5(); 는 private 메서드이므로

        // ITest4에 ITest2, ITest3까지 사용가능
        ITest4 obj4 = new Sub1();
        // Object는 최상위 클래스이므로 가능한데 이렇게는 잘 안씀!!
        Object obj5 = new Sub1();
    }
}
