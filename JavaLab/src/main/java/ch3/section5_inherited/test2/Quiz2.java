package ch3.section5_inherited.test2;

// test1... 유지보수성을 고려하지 않고 작성한 경우
class User{
    // 이 클래스의 아래 변수들이 어디서든 이용 가능하게 하고자 하는 것
    // 어느 순간... 회사의 정책 변경됨
    // name 벼수 값을 변경 가능하게 하기는 하겠지만..
    // 중요 데이터가 변경되는것이므로... 적절한 권한 체크해서 적절한 권한을 가진 경우에만 변경해야함
    // age값 획득은 가능하지만,, 이후 법적 문제 등을 고려해서 로그로 남기기로 함

    // 권한, 로그.. 남기려면 함수가 필요!!!
    // 바로 변수에 접근하는 것을 거부!!
    private String name;
    private int age;

    public void setName(String name){
        System.out.println("권한 체크 로직");
        this.name = name;
    }
    public int getAge(){
        System.out.println("적절한 로그");
        return age;
    }
}

// test2... 유지보수성을 고려해서 처음부터 아래처럼 작성하는 것이 바람직!!!
class User1 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("권한 체크");
        this.name = name;
    }

    public int getAge() {
        System.out.println("로그");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Quiz2 {
    public static void main(String[] args) {
//        User user1 = new User();
//        user1.name = "lee";
//        System.out.println(user1.age);

        // test2...
        User1 user1 = new User1();
        user1.setName("lee");
        user1.getAge();

    }
}

// 클래스를 선언할 때..
// 멤버 변수는 기본이 private!!!! - 외부에서 접근 못하게 하고!!
// 혹시 풀어줘야하는 상황이 있으면 -> default나 protected로 변경하기!!!
// 이 변수 값을 이용할 수 있는 public의 getter/setter 함수를 제공하는 것이 기본!!
// 외부에서는 이 클래스의 데이터를 변수가 아닌 함수로 이용하도록!!
// ==> 캡슐화  (encapsulation)
// ==> 캡슐화를 통해 정보 은닉!

