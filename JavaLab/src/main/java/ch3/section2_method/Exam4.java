package ch3.section2_method;

// 함수 오버로딩 테스트

// 이 클래스의 함수를 이용하면 애플리케이션의 로그를 출력시켜 줌.
// 개발시에 디버깅 목적으로 System.out.println() 해서 콘솔창에 로그를 남기는 것도 중요
// But, 운용 환경에서도 다양한 로그를 남김
class Log{
    // 아래는 너무 비효율적!!!
//    void log(String arg){ System.out.println(arg);}
//    void logInt(int arg){ System.out.println(arg); }
//    void logBoolean(boolean arg){System.out.println(arg);}

    // 동일 행동이라면 동일 이름으로!!!!, 더 간편!!!
    void log(int arg){}
    void log(boolean arg){}

}

public class Exam4 {
    public static void main(String[] args){
        Log obj = new Log();

//        obj.log("I'm sleepy");
//        obj.logInt(10);
//        obj.logBoolean(true);

        obj.log(10);
        obj.log(true);

    }
}
