package ch2.section2;

public class Quiz1 {
    public static void main(String[] args) {
        int a = 11;
        if(a>=3 && a<=5) System.out.println("봄입니다.");
        else if(a>=6 && a<=8) System.out.println("여름입니다.");
        else if(a>=9 && a<=11) System.out.println("가을입니다.");
        else if(a==1 || a==2 || a==12) System.out.println("겨울입니다.");
    }
}

// 랜덤으로 하는 방법!!
//public class Main{
//    public static void main(String[]args){
//        //Math.random() : 0~1 사이의 실수가 랜덤으로 나온다..
//        //0~100까지의 랜덤.. *100
//        //Math.random() * 12 : 0~12의 랜덤..
//        //(int) 로 캐스팅 : 0~<12
//        int randomValue = (int) (Math.random() * 12) + 1;
//        System.out.println("random : " + randomValue);
//        if(randomValue>=3&&randomValue<=5) {
//            System.out.println(randomValue + " 봄입니다.");
//        }
//        else if(randomValue>=6&&randomValue<=8) {
//            System.out.println(randomValue + " 여름입니다.");
//        }
//        else if(randomValue>=9&&randomValue<=11) {
//            System.out.println(randomValue + " 가을입니다.");
//        }
//        else if(randomValue==12||randomValue<=2) {
//            System.out.println(randomValue + " 겨울입니다.");
//        }
//
//    }
//}

