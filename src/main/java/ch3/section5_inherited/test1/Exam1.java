package ch3.section5_inherited.test1;

// 모든 학생의 공통 코드... 변수, 함수...
class Student {
    String name;
    int score;

    // getN 하고 enter 찌면 자동 완성 됨
    // or 변수 선언에 커서 두고 우클릭 > 생성  > setter, getter 생성 가능!!!

    String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }
    int getScore(){
        return score;
    }
    void setScore(int score){
        this.score = score;
    }
}

// 하위 클래스
class HighStudent extends Student {
    int classNumber;

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}

class UniversityStudent extends Student {
    String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

public class Exam1 {
    public static void main(String[] args) {
        UniversityStudent obj1 = new UniversityStudent();
        HighStudent obj2 = new HighStudent();

        //obj1.name="이수지";
        obj1.setName("이수지");
        obj1.setScore(40);
        obj1.setMajor("컴퓨터공학");

        obj2.setName("문승주");
        obj2.setScore(40);
        obj2.setClassNumber(2);

        System.out.println(obj1.getName() + " " + obj1.getScore() + " " + obj1.getMajor());
        System.out.println(obj2.getName() + " " + obj2.getScore() + " " + obj2.getClassNumber());

    }
}
