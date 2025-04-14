package ch2.section3;

public class Quiz2 {
    public static void main(String[] args) {
        int[] arr = {7, 44, 16, 32, 1, 22};

        // 정렬하여 출력
        // 출력 결과 : 1, 7, 16, 22, 32, 44

        // 2개씩 비교
        // 7, 44, 16, 32, 1, 22
        // 7 16 32 1 22 44
        // 7 16 1 22 32 44
        // 7 1 16 22 32 44
        // 1 7 16 22 32 44

        int c;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    c = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = c;
                }
            }
        }
        for(int data : arr)
            System.out.print(data + " ");
    }
}
