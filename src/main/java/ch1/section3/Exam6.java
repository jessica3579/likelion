package ch1.section3;

public class Exam6 {
    public static void main(String[] args) {
        User user = null;
        user.addUser();
    }
}

class User {
    void addUser() {
        String name = "Hello";
    }
}

//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "ch1.section3.User.addUser()" because "user" is null
//	at ch1.section3.Exam6.main(Exam6.java:6)
