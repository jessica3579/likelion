package ch4.section4_thread;

// thread test..
class Food extends Thread{
    // 독립 스레드에 의해서 처리될 시간이 오래 걸리는 업무를 구현하는 곳
    // 새로운 스레드에 의해 run이 호출되고.. run이 끝나면 그 스레드는 자동 종료
    @Override
    public void run() {
        for(int i=1; i<=10; i++)
            System.out.println("음식먹기 " + i);
    }
}
//class Phone extends Thread {
//    @Override
//    public void run() {
//        for(int i=1; i<=10; i++)
//                    System.out.println("전화받기 " + i);
//    }
//}
class Phone implements Runnable {
    @Override
    public void run() {
        for(int i=1; i<=10; i++)
                    System.out.println("전화받기 " + i);
    }
}

public class Exam1 {
    // 앱이 실행되면서 처음 발생된 실행흐름(jvm이 만든 실행흐름)을
    // 흔히 용어로 main thread라고 함
    public static void main(String[] args) {
        Food work1 = new Food();
        //Phone work2 = new Phone(); // extends thread
        Phone phone = new Phone(); // implements runnable
        Thread work2 = new Thread(phone);

        work1.start(); // 스레드 구동
        work2.start(); // 스레드 구동
        for(int i=1; i<10; i++){
            System.out.println("TV 보기 " + i);
        }
    }
}
