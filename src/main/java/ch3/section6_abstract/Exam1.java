package ch3.section6_abstract;

class Super1 { }

abstract class Super2 {
    // 클래스가 추상형으로 선언되었고, 추상 함수가 없다... 상관 없다..
    // 이런 클래스는 의미 없음
}

//class Super3 {
//    // 추상 함수가 선언되어 있다면 그 클래스도 추상형으로 선언해야함
//    abstract void method(); // error..
//}

abstract class Super4 {
    //abstract  void  method1(){} // error - 추상형으로 선언된 함수는 body를 가질 수 없음
    abstract void method1();
    // 클래스가 추상형이라고 하더라도 정상 함수 선언도 가능
    void method2(){}
}

// 추상 클래스 하위를 추상형으로 만들면 에러는 사라지지만 이 클래스는 객체 생성 불가
abstract class Sub extends Super4{ }

class Sub2 extends Super4{
    // 상위의 추상 함수를 모두 오버라이드 해야함
    // 함수 재정의니까 자신에게 추상함수가 상속되지 않음
    // 이 클래스는 추상함수를 가지지 않으므로 객체 생성 가능!!
    @Override
    void method1() {

    }
}

abstract class Student{
    String name;
    int score;
    Student(String name, int score){ // 생성자
        this.name = name;
        this.score = score;
    }
    abstract void examTake();
    abstract void examSolve();
    abstract void examSubmit();

    void doExam(){
        // 아래의 함수를 호출하려면
        // 이 클래스를 작성하는 시점에 함수가 선언되어 있어야 함!!
        // 그러나 각 함수의 행위가 하위 클래스마다 로직이 다름 -> 추상형으로!!
        examTake();
        examSolve();
        examSubmit();
    }
}

class HighStudent extends Student {
    HighStudent(String name, int score){
        super(name, score);
    }

    @Override
    void examTake() {
        System.out.println("High take..");
    }

    @Override
    void examSolve() {
        System.out.println("High solve..");
    }

    @Override
    void examSubmit() {
        System.out.println("High submit");
    }
}

public class Exam1 {
    public static void main(String[] args) {
        Super1 obj1;
        Super2 obj2; // 추상 클래스도 타입으로는 이용 가능
        obj1 = new Super1();
        //obj2 = new Super2(); // error - 추상 클래스는 생성 불가
        // 추상 클래스 그 자체가 사용될 수는 없음

        Student student = new HighStudent("kim", 30);
        student.doExam();
        // Student 클래스의 doExam 함수를 호출,
        // but 실제로 호출된것은 HightStudent클래스의 함수 => 다형성!!!

    }
}
