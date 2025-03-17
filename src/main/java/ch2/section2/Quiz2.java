package ch2.section2;

//public class Quiz2 {
//    public static void main(String[] args) {
//        int month = 22;
//        String str;
//        switch(month){
//            case 3:
//            case 4:
//            case 5:
//                str = "봄입니다.";
//                break;
//            case 6:
//            case 7:
//            case 8:
//                str = "여름입니다.";
//                break;
//            case 9:
//            case 10:
//            case 11:
//                str = "가을입니다.";
//                break;
//            case 1:
//            case 2:
//            case 12:
//                str = "겨울입니다.";
//                break;
//            default:
//                str = "잘못된 값입니다.";
//                break;
//        }
//        System.out.println(str);
//    }
//}


import java.util.Random;

public class Quiz2 {
    public static void main(String[] args) {
        int number = new Random().nextInt(1, 13);
        String season = switch (number) {
            case 3, 4, 5 -> "봄입니다.";
            case 6, 7, 8 -> "여름입니다.";
            case 9, 10, 11 -> "가을입니다";
            default -> "겨울입니다.";
        };

        System.out.println(season);
    }
}