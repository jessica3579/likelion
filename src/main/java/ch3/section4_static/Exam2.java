package ch3.section4_static;

// static과 this...

public class Exam2 {
    int objVar = 0;
    static int staticVar = 0;

    void objMethod(){
        // object member의 함수에서는 object member, static member 모두 이용 가능
        objVar++;
        staticVar++;
        staticMethod();
    }
    static void staticMethod(){
        // static 함수에서 object 멤버 이용이 불가능함
        // 이용하려면 이곳에서 객체 생성해서 메모리 할당을 한 다음에 이용해야함
        //objVar++; // error
        staticVar++;
        //objMethod(); // error
    }
    public static void main(String[] args){
        staticVar++;

        Exam2 obj = new Exam2();
        obj.objVar++;
    }

}
