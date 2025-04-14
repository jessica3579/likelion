package ch3.section5_inherited.test8;

// final test... 클래스, 변수, 함수 선언위치에 추가되는 예약어..

// 클래스에 final을 쓰면 다른 클래스에서 final 클래스를 상속 받을 수 없음
final class Super{
    // 변수 앞에 선언... 상수 변수..
    final int a = 0;
    final int b;
    Super(int a, int b){
        // final 로 변수를 선언과 동시에 값을 주지 않고 생성자에서 초기값을 줄 수는 있다.
        this.b = b;
    }
    //final Super(){} // error -final은 생성자에는 사용 못함

    // 함수에 final을 쓰면 override 금지를 뜻함!!!
    // 여기서 준비한 알고리즘으로만 쓰고 재정의는 하지 말라는 뜻
    final void method(){}
}
//class Sub extends Super {
//    Sub(){
//        super(10, 20);
//    }
////    @Override
////    void method(){
////        super.method();
////    }
//}

public class Exam8 {
}
