package ch3.section2_method;

// 가변 인수 테스트
public class Exam3 {
    void method1(int arg1, int arg2) {}

    void method2(int... args){
        // instanceof - 객체의 타입 확인 연산자!!!!
        System.out.println(args instanceof int[]);
        for(int v : args){
            System.out.print(v + " ");
        }
        System.out.println();
    }

    // 가변 인수와 다른 인수를 같이 선언 가능
    void method3(String arg1, int... args){
        System.out.println(arg1);
        for(int data : args){
            System.out.print(data + " ");
        }
        System.out.println();
    }

    // 아래는 모두 에러

    // 가변 인수는 하나의 함수 내에서 한번만
    //void method4(String... arg1, int... arg2){}

    // 가변 인수는 다른 인수랑 같이 선언된다면 마지막에 위치해야함!!!
    //void method5(int... args, String args){}


    public static void main(String[] args) {
        Exam3 obj = new Exam3();
        obj.method1(10, 20);

        obj.method2();
        obj.method2(10);
        obj.method2(10, 20, 30, 40, 50, 60);

        obj.method3("안뇽", 1, 2, 3, 4, 5, 6);


    }
}
