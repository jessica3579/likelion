package ch2.section2;

import java.util.Scanner;

public class Quiz3 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.print("소수인지 판단할 숫자 : ");
        int num = stdin.nextInt();

        // 입력받은 숫자보다 작은 숫자로 나눠서
        // 나누어 떨어지는게 없으면 소수
        // 1 제외

//        boolean isPrime = true;
//
//        if (num < 2) {
//            isPrime = false;
//        } else {
//            for (int i = 2; i < num; i++) {
//                if (num % i == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//        }
//
//        if (isPrime) {
//            System.out.println("소수입니다.");
//        } else {
//            System.out.println("소수가 아닙니다.");
//        }

        // 강사님 코드
        int divisor = 2;
        boolean isPrime = true;

        while (divisor < num){
            if(num % divisor == 0){
                isPrime = false;
                break;
            }
            divisor ++;
        }

        if(num==2 || isPrime){
            System.out.println(num + "은 소수입니다.");
        }else {
            System.out.println(num + "은 소수가 아닙니다.");
        }


    }
}
