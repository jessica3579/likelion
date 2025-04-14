package ch3.section8_exception;

// throw, throws
public class Exam2 {
    void method1() {
        try {
            int result = 10 / 0;
        } catch (Exception e) {

        }
    }

    void method2() throws ArithmeticException { // throws로 경고!!
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            // 실제 exception이 전파되는 순간
            // return과 동일한 효과!
            // throw아랫줄은 실행 안됨
            throw new ArithmeticException();
        }
    }

    void method3() throws ArithmeticException {
        try {
            throw new ArithmeticException(); // 가능 - throw를 catch에서만 사용하는 것은 아님, 함수 전역에서!!
        } catch (ArithmeticException e) {
            // throw e; // 가능 - catch의 매개변수가 자신이 발생한 예외상황.. 그걸 그대로 발생...
            // throw new Exception(); // error - throws에 선언된 exception보다 상위 타입의 exception을 던질수 없음
        }
    }

    public static void main(String[] args) {
        Exam2 obj = new Exam2();
        System.out.println("step1");
        obj.method1();
        System.out.println("step2");
        //step1
        //step2
        //==> method1 에서 exception이 발생했고 catch에서 대응했다.
        // 이 함수를 호출한 쪽에서는 exception 발생상황을 모름.
        // 다만 catch로 인해 예외가 발생해도 프로그램에 종료되지 않음
        // 프로그램이 종료되면 step2 실행 안됨

        // throw에 의해.. 이 라인에서 에러가 발생한 효과!!!
        try {
            //obj.method2();
        } catch (Exception e) {

        }
//        System.out.println("step1");
//        obj.method2();
//        System.out.println("step2");
        // 위와 같이 작성하면 exception 발생해서 step1만 출력되고 step2는 출력 안됨

        System.out.println("step1");
        try {
            obj.method2();
        } catch (Exception e) {}
        System.out.println("step2");
        // 위와 같이 작성하면 exception 발생해도 try-catch 문으로 예외처리 했기때문에
        // 프로그램이 종료되지 않고 step1, step2까지 잘 출력됨
        // ArithmeticException은 Runtime Exception이므로 예외처리가 필수가 아니므로
        // obj.method2()이렇게 작성해도 되긴함
    }
}
