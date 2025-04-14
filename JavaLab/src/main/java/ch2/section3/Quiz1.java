package ch2.section3;

public class Quiz1 {
    public static void main(String[] args) {
        int[] arr = {76, 92, 49, 78, 83};
        int max = 0, min = 100, sum =0, avg;

        for (int score : arr) {
            if (max < score) max = score;
            if (min > score) min = score;
            sum += score;
        }
        avg = sum / arr.length;

        System.out.println("최고 점수 : " + max);
        System.out.println("최저 점수 : " + min);
        System.out.println("점수 총합 : " + sum);
        System.out.println("점수 평균 : " + avg);
    }
}
