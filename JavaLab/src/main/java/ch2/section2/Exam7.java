package ch2.section2;

import java.util.Scanner;

public class Exam7 {
    public static void main(String[] args) {
        // JVM으로 실행시키면서 준 데이터는 main 함수의 args에...
        // >java Exam7 hello world

        // jvm 에서 실행 도중에 콘솔 창에서 유저가 입력한 데이터를 획득
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("메시지를 입력한 후 Enter를 치세요.(종료하려면 quit)");
            String message =  sc.nextLine();
            System.out.println("입력한 메시지 : " + message);
            // equals() - 문자열이 같은지 비교...
            if(message.equals("quit")){
                break;
            }
        }
    }
}
