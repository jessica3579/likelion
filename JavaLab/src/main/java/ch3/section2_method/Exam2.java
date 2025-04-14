package ch3.section2_method;

// call by value, call by reference
class User {
    String name;
    int score;
}
public class Exam2 {
    // 매개변서 2개를 받아들여서 둘의 값을 바꾸기
    void changeValue1(int score1, int score2){
        int temp;
        temp = score1;
        score1 = score2;
        score2 = temp;
    }
    void changeValue2(User u1, User u2){
        int temp;
        temp = u1.score;
        u1.score = u2.score;
        u2.score = temp;
    }

    public static void main(String[] args){
        User u1 = new User();
        u1.name = "이수지";
        u1.score = 100;

        User u2 = new User();
        u2.name = "문똥꾸";
        u2.score = 50;

        System.out.println(u1.name + ", " + u1.score + " : " + u2.name + ", " + u2.score);
        // changeValue(); -> 에러남, Exam2 객체를 생성해야 호출 할 수 있음
        // call by value - 함수 내에서 전달한 데이터가 변경이 된다고 하더라도
        // 호출한 곳에는 영향을 주지 않음
        Exam2 obj = new Exam2();
        obj.changeValue1(u1.score, u2.score);
        System.out.println(u1.name + ", " + u1.score + " : " + u2.name + ", " + u2.score);
        // 값이 바꿔지지 않음!!!!!!!! 객체를 넘긴게 아니라 값을 넘겨서 값이 안바뀜 -> call by value

        // call by reference
        obj.changeValue2(u1, u2); // -> 객체를 넘김, call by reference, 객체의 주소가 넘어감
        // 두 함수에서 이용하는 객체가 동일
        System.out.println(u1.name + ", " + u1.score + " : " + u2.name + ", " + u2.score);
        // 값이 정상적으로 바뀜!!!


    }
}
