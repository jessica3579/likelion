package ch2.section1;

// 식별자, 예약어 테스트!!

public class Exam1 {
    int count = 0;
    int count1 = 10; // 식별자에 숫자 사용가능(단, 첫글자만 빼고!)
    int count1data = 10;
    // 식별자에 사용할 수 있는 특수키는 _, $
    int count_data = 10;
    int count$data = 10;
    // 원한다면 각국 언어도 가능! 근데 보통 영어로 씀
    int 카운트 = 10;

    // error 예시
    //int 1count = 10;
    //int count-1 = 10;
    //int count*data = 10;
    //int count data = 10;
    //int final = 10;

    public static void main(String[] args) {
        Exam1 객체 = new Exam1();
        객체.카운트 = 20;
        System.out.println(객체.카운트);
    }


}
