package ch3.section1_oop;

class Student{
    String name;
    int score;

    void printInfo(){
        System.out.println(name + "의 점수 : " + score);
    }
}

public class Exam2 {
    public static void main(String[] args) {
        // 객체 생성
        Student s1 = new Student();
        s1.name = "Lee";
        s1.score = 100;
        s1.printInfo();

        // 또 다른 객체 생성
        Student s2 = new Student();
        s2.name = "moon";
        s2.score = 100;
        // printInfo의 return type은 void이므로
        // System.out.println(s2.printtInfo());
        // 이런식으로 작성하면 error 남
        s2.printInfo();

        // 2개의 객체가 생성되었고 각각 따로 메모리가 할당된다.
        // 즉 하나의 클래스로 만들었지만 각기 메모리를 가지고 있어,
        // 각각의 데이터를 자신 객체에 메모리를 유지

        // 객체는 reference variable(참조 변수)임
        // 참조 변수 : 주소값이 들어간 변수
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2); // false

        // 객체를 선언했지만 new로 새로 생성한 것이 아니라( = 새로운 메모리를 생성한 것이 아님)
        // 기존에 있던 객체(s1)을 그대로 대입
        // 기존 메모리 주소를 복사한 경우
        // 두 객체는 동일한 메모리를 지칭(참조)하게 됨
        Student s3 = s1;
        System.out.println(s1.name + ", " + s3.name); // Lee, Lee
        s1.name = "Park";
        System.out.println(s1.name + ", " + s3.name); // Park, Park
        s3.name = "Hong";
        System.out.println(s1.name + ", " + s3.name); // Hong, Hong

        System.out.println(s1 == s3); // true



    }
}
