package ch3.section5_inherited.test2;

class Super {
    {
        System.out.println("1");
    }
    static {
        System.out.println("2");
    }

    int a;

    Super() {
        System.out.println("3");
    }
}

class Sub extends Super {
    {
        System.out.println("4");
    }
    static {
        System.out.println("5");
    }

    int b;

    Sub() {
        System.out.println("6");
    }
    Sub(int a) {
        this();
        System.out.println("7");
    }
}

public class Quiz1 {
    public static void main(String[] args) {
        new Sub();  // 2 5 1 3 4 6
        new Sub(10); // 1 3 4 6 7
    }
}
