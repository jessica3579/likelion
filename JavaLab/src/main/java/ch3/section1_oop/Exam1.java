package ch3.section1_oop;

// 클래스 선언 및 객체 생성 테스트
// 클래스의 구성은 변수, 함수, 생성자...
//class Car {
//    // 멤버 변수
//    double KILOMETERS_PER_LITER; // 연비
//    double kilometerDriven; // 주행거리
//    double lightOil; // 현재 주유되어있는 기름
//
//    // 생성자 - 객체 생성 역할!
//    Car() {
//        KILOMETERS_PER_LITER = 30;
//        kilometerDriven = 0;
//        lightOil = 0;
//    }
//    Car(double kpl){ // 연비를 받음
//        if(kpl > 0){
//            KILOMETERS_PER_LITER = kpl;
//        } else {
//            KILOMETERS_PER_LITER = 30;
//        }
//        kilometerDriven = 0;
//        lightOil = 0;
//    }
//
//    // 멤버 메서드(함수)
//    double getKilometersPerLiter(){
//        return KILOMETERS_PER_LITER;
//    }
//    double getKilometersDriven(){
//        return kilometerDriven;
//    }
//    void addLiteOil(double amount){
//        if(amount > 0){
//            lightOil += amount;
//        }
//    }
//    void drive(double kilometers){
//        if(kilometers < KILOMETERS_PER_LITER){
//            kilometerDriven += kilometers;
//            lightOil -= kilometers / KILOMETERS_PER_LITER;
//        } else {
//            System.out.println("기름이 부족합니다.");
//        }
//
//    }
//
//}
//
//public class Exam1 {
//    public static void main(String[] args) {
//        // 클래스를 기반으로 객체 생성 사용...
//        // 객체 생성 순간에 메모리 할당
//        Car car = new Car(20);
//        //생성된 객체에(car)에는 메모리 주소값이 있음
//        // 객체의 멤버는 객체명으로!
//        car.addLiteOil(40); // 40 주유함
//        car.drive(100); // 100키로 달릴거임
//    }
//}

class Car{
    double KILOMETERS_PER_LITER;
    double kilometerDriven;
    double lightOil;

    Car(){
        this.KILOMETERS_PER_LITER = 30;
        lightOil = 0;
    };
    Car(double KILOMETERS_PER_LITER){
        if(KILOMETERS_PER_LITER > 0 ) this.KILOMETERS_PER_LITER = KILOMETERS_PER_LITER;
        else this.KILOMETERS_PER_LITER = 30;
    }
    double getKilometerPerLiter(){
        return KILOMETERS_PER_LITER;
    }
    double getKilometerDriven(){
        return kilometerDriven;
    }
    double getLightOil(){
        return lightOil;
    }
    void addLiteOil(double lightOil){
        this.lightOil += lightOil;
    }
    boolean drive(double kilo){
        if(kilo < lightOil / KILOMETERS_PER_LITER) return false;
        else{
            kilometerDriven += kilo;
            lightOil -= kilo/KILOMETERS_PER_LITER;
            return true;
        }
    }
}
public class Exam1{
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car(10);

        c1.addLiteOil(30);
        c2.addLiteOil(30);

        System.out.println(c1.drive(1000));
        System.out.println(c2.drive(1000));

    }
}
