package ch2.section2;

public class Quiz5 {
    public static void main(String[] args) {

        for(int i = 1; i < 10; i++){
            for(int j = 2; j < 10; j++){
                System.out.print(j + " * " + i + " = " + i*j + "\t\t");
            }
            System.out.println(" ");
        }
    }
}
