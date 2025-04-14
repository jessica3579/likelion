package ch3.section1_oop;

class Member {
    int memberId;
    String name, email, password, phoneNumber;

    Member(int memberId, String name, String email, String password, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    boolean register() {
        System.out.println("register함수");
        return true;
    }

    boolean login() {
        System.out.println("login함수");
        return true;
    }

    boolean logout() {
        System.out.println("logout함수");
        return true;
    }

    String getInfo() {
        System.out.println("getInfo함수");
        return memberId + ", " + name + ", " + email + ", " + password + ", " + phoneNumber;
    }
}

public class Quiz1 {
    public static void main(String[] args) {
        Member m1 = new Member(1, "이수지", "123@naver.com", "123", "010-1111-1111");
        Member m2 = new Member(2, "김수지", "456@naver.com", "456", "010-2222-2222");

        m1.register();
        m1.login();
        m1.logout();
        System.out.println(m1.getInfo());

        m1.register();
        m1.login();
        m1.logout();
        System.out.println(m2.getInfo());

    }
}
