package ch3.section4_static;

// static test...

class Count {
    int count;
    static int totalCount;

    void method1() {
    }

    static void method2() {
    }
}

public class Exam1 {
    public static void main(String[] args) {
        //method1(); // error
        //Count.method1(); // error -> 객체(object) 멤버들은 객체 생성 전에 사용할 수 없음

        // static 멤버는 객체 생성 전에 이용 가능
        // 클래스명.멤버명...
        Count.method2(); // 괜춘

        Count c1 = new Count();
        Count c2 = new Count();
        Count c3 = new Count();

        //Count.count++; // error - 객체 멤버는 객체명으로 접근!!!
        c1.count++;
        Count.totalCount++;

        c2.count++;
        Count.totalCount++;

        c3.count++;
        Count.totalCount++;

        System.out.println(Count.totalCount + " : " + c1.count);
        System.out.println(Count.totalCount + " : " + c2.count);
        System.out.println(Count.totalCount + " : " + c3.count);
        // 3 : 1
        //3 : 1
        //3 : 1

        // static 멤버!
        // 정칙은 클래스명.멤버명
        // 객체로 접근도 허용하기는 하지만 권장하지는 않음
        c1.totalCount++;
        c2.totalCount++;
        c3.totalCount++;

        System.out.println(Count.totalCount + ", " + c1.totalCount + ", " + c2.totalCount + ", " + c3.totalCount);



    }
}
