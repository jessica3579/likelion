package ch3.section3_constructor;

// 생성자...
class Student{
    String name;
    int score;
    boolean isPassed;
    String major;

    // 개발자가 명시적으로 생성자를 추가하지 않으면 컴파일러에 의해
    // default 생성자가 추가됨 (default constructor : 매개변수를 가지지 않는 생성자)
    // 마치 아래처럼 선언된 것과 동일
    //Student(){}

    // 학생 객체를 만들때, 나머지 데이터는 이후에 발생한다고 하더라도
    // 이름이 없는 학생은 존재하지 않음
    // 객체를 생성하면서 필수 데이터를 매개변수를 받아들여서 생성과 동시에 초기화되도록!!
    Student(String argName){this.name = argName;}
    // 생성자는 여러개 만들 수 있음
    // 다른 멤버 변수도 필요하다면.. 생성하면서 초기화 되도록 하고 싶으면
    Student(String argName, int argScore, boolean argPassed, String argMajor){
        //this.name = argName;
        this(argName);
        this.score = argScore;
        this.isPassed = argPassed;
        this.major = argMajor;
    }
    // 생성자를 여러개 선언하다 보면... 생성자내의 코드가 중복되는 경우가 많음
    // 일반 함수가 아니다보니, 생성되면서 코드에 의해 실행되는 부분이 생성과 동시에
    // 최초에 한번인 코드다 보니 대부분 중복!!!
    // this();
}

public class Exam1 {
    public static void main(String[] args) {
        // 객체 생성 구문
        // 객체 생성을 위한 생성자 호출 구문...
        //Student obj = new Student(); // error - Student() 생성자는 없기 때문!!
        Student obj = new Student("이수지");


    }
}
