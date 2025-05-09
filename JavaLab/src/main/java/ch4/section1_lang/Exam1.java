package ch4.section1_lang;

// Object 클래스 함수!!
class User { }

class Student extends User {
    String name;
    int age;
    // 이 클래스는 Object의 서브 클래스!
    // Object 내에 toString() 함수가 있다
    // Object 의 toSring()는 해시값(=주소값) 출력이다.
    // 데이터가 중심인 클래스를 만들때.. (함수가 중심인 곳에서는 잘 안함)
    // Object 의 toString()을 그대로 이용할 수도 있지만..
    // 자신이 override해서 자신의 데이터가 출력되게 재정의한다...
    // => 디버깅의 용이성을 위해..
    // 어떤 객체의 데이터가 어떻게 들어가 있지?를 확인하고 싶은 경우가 있다..
    // System.out.println(obj.name + "," + obj.age + "," + .... ); 하면 되긴 하지만 귀찮음
    // System.out.println(obj.toString()); 하면 데이터가 나오게끔..!
    @Override
    public String toString() {
        return "Student : " + name + ", " + age;
    }
}

public class Exam1 {
    public static void main(String[] args) {
        // Object... getClass()....
        // getClass() : 실제 생성된 객체의 클래스명이 문자열로..
        String str = "hello";
        System.out.println(str.getClass());
        User user = new User();
        System.out.println(user.getClass());
        User user2 = new Student();
        System.out.println(user2.getClass());
        //class java.lang.String
        //class ch4.section1_lang.User
        //class ch4.section1_lang.Student

        // Object - equals().........객체가 같은지 비교........
        User user3 = new User();
        User user4 = user;
        System.out.println(user.equals(user3)); // false
        System.out.println(user.equals(user4)); // true

        // Object - toString().............정보 출력....
        // 객체명만 지정해도 내부적으로 toString()이 호출되고.. 반환 정보가 출력
        System.out.println(user); // ch4.section1_lang.User@41629346
        // 위 아래는 동일 코드
        System.out.println(user.toString()); // ch4.section1_lang.User@41629346
        /// 위의 코드는 Object의 toString()이 이용된 것이고..
        // 아래의 코드는 Student에서 toString()을 오버라이드한 Student에 개발자가 정의한 함수가 호출됨
        System.out.println(user2); // Student : null, 0

        // Object는 최상위 타입이다.. 모든 자바 객체는 Object 타입으로 이용가능!!
        Object obj = new User();
        Object obj1 = new String("hello");
        Object[] array = {new User(), new String()};

    }
}
