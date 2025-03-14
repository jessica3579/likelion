package ch2.section1;

public class Quiz1 {
    public static void main(String[] args) {
        int javaScore = 83;
        int pythonScore = 100;
        int ex_score;

        System.out.println("[ 교환 전 ]");
        System.out.println("javaScore: " + javaScore);
        System.out.println("pythonScore: " + pythonScore);

        ex_score = javaScore;
        javaScore = pythonScore;
        pythonScore = ex_score;

        System.out.println("----------------");
        System.out.println("[ 교환 후 ]");
        System.out.println("javaScore: " + javaScore);
        System.out.println("pythonScore: " + pythonScore);
    }
}
