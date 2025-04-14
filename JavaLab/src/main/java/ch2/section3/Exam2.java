package ch2.section3;

public class Exam2 {
    public static void main(String[] args) {
        int[] scores = {10, 20, 30, 40, 50};

        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
        }// 1020304050

        System.out.println(" ");

        //scores - 배열처럼 여러건의 데이터를 가지는 객체..
        //알아서 배열의 갯수만큼 for 문 반복 실행..
        //no - index 가 아니라.. 순차적으로 추출된 데이터..
        for (int num : scores) {
            System.out.print(num);
        } // 1020304050


    }
}
