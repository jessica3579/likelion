package ch3.section2_method;

// 메서드
public class Exam1 {
    void method1() {
        System.out.println("method1 call");
    }

    void method2(int arg1, String arg2, boolean arg3, int arg4) {
        System.out.println(arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4);

    }

    //    오류 : 리턴타입이 String이여야하는데 return 코드가 없음
//    String method3(){
//
//    }
    String method3(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        //return sum; // error: return type과 맞지 않아서!!!
        return "1부터 " + num + "까지 더한 결과는 " + sum + "입니다";
    }

    void method4() {
        System.out.println("method 4 start....");
        System.out.println("method 4 end....");
    }

    void method5() {
        System.out.println("method 5 start....");
        // 다른 함수 호출..
        method4();
        System.out.println("method 5 end....");
    }

    void method6() {
        System.out.println("method 6 start....");
        // 다른 함수 호출..
        method5();
        System.out.println("method 6 end....");
    }

    public static void main(String[] args) {
        // method1 호출
        //method1(); // error
        // 객체지향이다.. 함수, 변수가 클래스 멤버이다.
        // 클래스의 객체를 먼저 생성하고
        // 객체.함수명()  형식으로 사용해야함
        Exam1 obj = new Exam1();
        obj.method1();
        obj.method1();

        obj.method2(10, "hello", true, 20);

        //String result = obj.method1(); // error : return type이 없으므로 오류
        //int result = obj.method3(10); // error : retury type이 String인데 변수는 정수형
        String result = obj.method3(10);
        System.out.println(result);

        // 순서 예측해보기!!
        System.out.println("main start");
        obj.method6();
        System.out.println("main end");

        //main start
        //method 6 start....
        //method 5 start....
        //method 4 start....
        //method 4 end....
        //method 5 end....
        //method 6 end....
        //main end
    }
}
