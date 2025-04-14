//package ch1.section31; // error - 자바 파일이 있는 물리적인 폴더 위치와 동일하게!!!!
//package aaa; // error - package는 가장 첫줄에 한번만 선언 가능!!!
package ch1.section3;

import ch1.section3.Exam1;
// 다른 패키지에 선언된 클래스를 이용하려면 import 구문으로 컴파일러에게 어떤 위치의 어느 클래스를 사용하는 것인지 알려줘야함!!!
// 동일 패키지의 다른 클래스를 사용한다면 import 없이 사용 가능!
import ch1.section3.sub.Exam1_2;
import ch1.section3.sub.*; // sub 폴더에 있는 파일 다 참조!
import java.util.Date; // java로 시작하는 패키지는 jdk에서 제공하는 클래스
import java.io.Writer;

// 자바 파일 구성 요소 테스트 --------------------

// 변수 함수는 top level에  선언될 수 없음.
//int a = 10; // error
//void sayHello() {} // error

public class Exam2 {
    Exam1 obj; // 동일 패키지여서 사용 가능!
    //Some5 obj2; // error - import 해줘야함
    Exam1_2 obj3; // import 해줘서 error X

    // top level 구성요소는 클래스만 허용 => 모든 변수, 함수는 클래스 내에 선언되어야함.
    // 클래스의 멤버 변수, 함수..
    int a = 10;
    void sayHello() {}
}
