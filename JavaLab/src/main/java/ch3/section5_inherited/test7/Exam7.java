package ch3.section5_inherited.test7;

// override test

// 상위..
class Student{
    String name;
    int score;
    void printInfo(){
        System.out.println(name + "의 점수는 " + score);
    }
    void method(){}
}

class UniversityStudent extends Student {
    String major;
    // override 로 상위 함수 상속되지 않게 하고
    // 동일 행동을 자신이 재정의!!

    @Override
    void printInfo() {
        // super가 꼭 들어가야하는 것은 아님
        // ????
        super.printInfo();
        System.out.println(name + ", " + major + ", " + score);
    }

//    void method(){} // ok.. 오버라이드 O
    void method(int a){} // ok.. 오버라이드 X 오버로딩O
    // 매개변수를 다르게 하면 상위 함수가 상속된다.
    // 현 클래스 내에 동일 이름의 함수가 2개가 되는 것!!

    //public void method(){} // ok.. 상위의 접근 제한자 교체 가능!!
    //private void method(){} // error.. 오버라이드하면서 접근제한의 범위를 넓히는건 가능
    // 그렇지만 줄일수는 없음

    //int method(){return 0;} // error... return type 바꾸면 안됨
}

public class Exam7 {
    public static void main(String[] args) {
        UniversityStudent obj = new UniversityStudent();
        obj.name = "kim";
        obj.score = 100;
        obj.major = "컴퓨터공학";
        obj.printInfo();
    }
}
