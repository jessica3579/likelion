package ch1.section3;

// main() 함수 test
public class Exam3 {
    // JVM에 의해 실행될 클래스는 main 함수를 가지고 있어야함!
    public static void main(String[] args) {
        // JVM에 의해 전달되는 데이터 확인
        for(String arg: args){
            System.out.println(arg); // 출력
        }
    }


}

// class 파일이 위치하는 java/main 디렉토리에서 명령어 입력
// java ch1.section3.Exam3 -> JVM 머신 돌리기

// java ch1.section3.Exam3 hello 10
// hello (출력값)
// 10  (출력값)
