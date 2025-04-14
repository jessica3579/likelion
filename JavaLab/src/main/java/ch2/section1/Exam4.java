package ch2.section1;

public class Exam4 {
    public static void main(String[] args) {
        int a = 10;
        double b = 10;
        b = a; // b( 더 큰 자료형 )에 a(더 작은 자료형)을 넣는거라 괜춘
        //a = b; // a (더 작은 자료형)에 b(더 큰 자료형)을 넣은거라 안됨
        a = (int)b; // 명시적 캐스팅
        int a2 = (int)b; // 명시적 캐스팅
        System.out.println("a : " + a);

        double d3 = 20.34;
        int a3 = (int)d3;
        System.out.println(((Object) b).getClass().getSimpleName()); // Double (b의 타입 출력)

        // char도 정수로 표현이 될 수 있음
        char c = 'A';
        int a4 = c;
        System.out.println("a4 : " + a4); // ascii 코드표 : 각 문자에 해당되는 정수값이 있다.

        // 영문자가 아닌 각국 언어의 문자도 정수화 될 수는 있지만
        // 큰 수로 나와서 큰 의미는 없음.
        // char로 정수화 시켜서 로직을 잡는 경우 일반적으로 영문자 알파벳
        char c2 = '가';
        int a5 = c2;
        System.out.println("A : " + a5); // A : 44032

        // 가장 많이 발생하는 캐스팅은
        // "10" <-> 10
        // String <-> int
        // 캐스팅은 기초 타입의 데이터들만..!
        // String은 문자열을 쉽게 사용하기 위한 클래스임! 따라서 캐스팅이 안됨
        // 별도의 함수를 제공하고 그 함수를 이용해서 변형시킴
        String str = "10";
        int intData = Integer.parseInt(str); // 10
        String str2 = String.valueOf(20);  // "20"
        System.out.println("intData : " + intData);
        System.out.println(((str2)+10) + ", " + (intData + 10));

//        String str3 = "hello";
//        int intStr3 = Integer.parseInt(str3);
//        System.out.println("intStr3 : " + intStr3); // error(NumberFormatException)
    }
}
