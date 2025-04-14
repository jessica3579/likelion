package ch2.section2;

public class Exam1 {
    public static void main(String[] args) {
        System.out.println("11 % 4 : " + (11 % 4 )); // 나머지
        System.out.println("11 / 4 : " + (11 / 4 )); // 몫
        System.out.println("10 % 4 : " + (10 % 4 ));
        // 정수로 연산이 나온 후에 그 데이터가 실수로 변형되어서 소수점 데이터가 사라짐
        System.out.println("10 / 4 : " + (double)(10 / 4 )); // 2.0
        // 나누기 연산이 진행되기 전에 실수로 바꾸어서 결과가 실수로 나옴
        System.out.println("10 / 4 : " + ((double)10 / 4 )); // 2.5

        // 복합 할당 연산자
        int data1 = 10;
        int result = data1 + 10;

        data1 = data1 + 10;
        data1 += 10;
    }
}
