package ch2.section1;

// type test.....

public class Exam3 {
    public static void main(String[] args) {
        boolean isPressed = true;
        char grade = 'A';
        // byte byte1 = 128; // error - byte는 127까지만
        byte byte1 = 127;

        // 자바 정수의 기본 타입은 int 타입
        short short1 = 17;
        int in1 = 120;
        long long1 = 10L; //long이라는 데이터라는 것을 명시적으로 표현하기 위해 데이터 뒤에 L 추가
        long long2 = 2;

        // 자바에서 실수의 기본 타입은 double
        // 따라서 float로 쓰려면 f 붙여야함!
        //float float1 = 10.20; // error
        float float1 = 10.2f; //f 로 float 타입의 데이터임을 명시적으로
        double double1 = 10.0;

        // 어떤 언어에서도 문자열을 표현하기 위한 기초타입을 제공하지는 못함
        // 문자열은 문자(char)의 배열로 표현이 기본.
        // 개발자가 코드에서 문자열을 char 배열로 핸들링하는건 너무 공부사 많이 듬
        // 이 문자열 처리를 마치 단일 데이터인 것 처럼 도와주기 위한 클래스를 제공
        // String 클래스는 자바에서 제공
        // 문자열은 꼭 " "(더블 쿼트)로 묶여야함
        String str = "hello world"; // String은 주황색이 아니라 흰색임! 즉, 클래스임! 그런데 그냥 type처럼 사용해도 됨

    }
}
