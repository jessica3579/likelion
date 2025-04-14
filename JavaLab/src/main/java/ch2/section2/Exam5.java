package ch2.section2;

//  switch - case 조건문 테스트

public class Exam5 {
    public static void main(String[] args) {
        int expression = 2;
        switch(expression){
            case 1:
                System.out.println("1");
                //break;
            case 2:
                System.out.println("2");
                //break;
            case 3:
                System.out.println("3");
                //break;
            default:
                System.out.println("1,2,3이외의 수");
                //break;
        }
    }
}
