package ch2.section1;

public class Exam5 {
    public static void main(String[] args) {
        final double PI = 3.1416;
        Employee cal = new Employee();
        cal.calBonus(2);
    }
}

class Employee {
    final int DEPARTMENT_SALE = 0;
    final int DEPARTMENT_DEV = 1;
    final int DEPARTMENT_MARKETING = 2;

    int department;

    // 코드의 명확성을 위해서 상수 변수를 선어해서 지정하는 것이 일반적

    void calBonus(int department) {
        if(department == DEPARTMENT_SALE){
            System.out.println("연봉에 10을 곱함");
        } else if (department == DEPARTMENT_DEV){
            System.out.println("연봉에 20을 곱합");
        } else if (department == DEPARTMENT_MARKETING) {
            System.out.println("연봉에 30을 곱합");
        }
    }

}