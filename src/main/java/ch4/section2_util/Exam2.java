package ch4.section2_util;

import java.util.regex.Pattern;

// Pattern test..
public class Exam2 {
    public static void main(String[] args) {
        // 유저에게 받은 데이터가 있다고 가정..
        String tel = "010-1234";
        //String email = "a@a.com";
        String email = "aa.com";

        // 유저에게 받은 데이터는 비 신뢰적이라고 판단.. 유효성 검증하고자 한다.
        // 우리가 원하는 패턴의 문자열인지 검사하고자 한다...
        // 원하는 패턴을 명시한 정규표현식 문자열을 준비...
        String telPattern = "01[0-9]-\\d{3,4}-\\d{4}"; // \d{4} : 숫자가 4개
        String emailPattern = "\\w+@\\w+\\.\\w+(\\.\\w+)?"; // \w : 문자 또는 숫자
        // \w+ : 문자 또는 숫자가 1개 이상
        // (\\.\\w+)? : .co 같은게 0개 또는 1개 -> ex) 123@kakao.co.kr 같은 것도 허용하기 위해

        if (Pattern.matches(telPattern, tel)) {
            System.out.println("정상적인 전화번호");
        } else {
            System.out.println("잘못된 전화번호");
        }

        if (Pattern.matches(emailPattern, email)) {
            System.out.println("정상적인 이메일");
        } else {
            System.out.println("잘못된 이메일");
        }


    }
}
