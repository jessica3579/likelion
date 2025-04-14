package ch3.section2_method;

class Math {
    int sum;

    int add(int a, int b) {
        sum = a + b;
        return sum;
    }

    int add(int a, int b, int c) {
        sum = a + b + c;
        return sum;
    }

    int add(int[] arr){
        sum = 0;
        for(int data : arr){
            sum += data;
        }
        return sum;
    }
}

public class Quiz1 {
    public static void main(String[] args) {
        Math m = new Math();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(m.add(1,2));
        System.out.println(m.add(1,2,3));
        System.out.println(m.add(arr));
        System.out.println(m.add(new int[]{10, 20, 30, 40, 50}));
    }
}
