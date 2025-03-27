package ch4.section1_lang;

// Wrapper 클래스 test...
public class Exam3 {
    public static void main(String[] args) {
        // 기초 타입의 데이터를 객체로 이용해야 하는 경우..
        // Object 타입의 배열에 int, boolean, double은 객체가 아니기때문에 직접 들어갈 수 없음
        // 따라서 new Integer(10)과 같은 식으로 객체로 감싸줘야함 = boxing(박싱)
        Object[] objArray = {
                new Integer(10),
                new Boolean(true),
                new Double(10.0),
        };

        // 원래는 위처럼 사용해야 하는데 편의성의 위해서 마치 값을 직접 준것처럼 사용 가능
        // 내부적으로는 객체가 만들어져서 들어감. - auto boxing
        Object[] objArray2 = {
                10, true, 10.0
        };

        int score1 = 60;
        Integer wrapper1 = new Integer(score1); // 정상적인 박싱:기초 타입을 객체로 감쌌다는 의미에서 용어로 박싱이라고 함
        Integer wrapper2 = Integer.valueOf(score1);// valueOf: 기본형->객체로 바꾸는 static method
        int a1 = wrapper1.intValue(); // 언박싱:박싱된 것을 다시 원 데이터로..(객체:Integer -> 기본형:int)

        // 편의성을 위해서 제공.. - auto boxing
        Integer b1 = score1; // auto boxing : 기본형(int) -> 객체(Integer)
        int c1 = b1; // auto unboxing : 객체(Integer) -> 기본형(int)

        // 추가로 new Integer(score1);   vs   Integer.valueOf(score1);
        // 둘다 boxing!! 기본형 -> 객체로 바꿈
        // new Integer(score1);의 경우 매번 새로운 객체 생성 -> 메모리 관점에서 비효율적
        // Integer.valueOf(score1);의 경우 캐시된 객체 재사용 -> 효율적 
    }
}
