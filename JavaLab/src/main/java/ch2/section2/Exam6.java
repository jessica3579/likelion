package ch2.section2;

// while 테스트....

public class Exam6 {
    public static void main(String[] args) {
        // 1부터 10까지 더하기
        int sum = 0;
        int i = 0;
        while(i <= 10){
            sum += i;
            i++;
        }
        System.out.println("sum : " + sum );

        // 1부터 10까지 짝수만 더하기
        sum = 0;
        i = 0;
        while(i <= 10){
            if(i % 2 == 0){
                sum += i;
            }
            i++;
        }
        System.out.println("짝수 sum : " + sum );

        // 구구단 찍기... 2단부터 9단까지
        i=2;
        while(i < 10){
            System.out.println("=====" + i + "단=====");
            int j=1;
            while(j < 10){
                System.out.println( i + " * " + j + " = " + i*j);
                j++;
            }
            i++;
        }

    }
}
