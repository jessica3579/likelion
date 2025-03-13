package ch1.section3;

// 하나의 자바 파일에 필요에 의해 여러 클래스를 선언할 수 있다.
//class Some1 {}
//class Some2 {}

// public으로 클래스가 선언될 수 있지만..
// public으로 선언된 클래스는 파일명과 대소문자가 동일해야함.
//class Some1 {}
//public class Some2 {} // error

// 하나의 자바 파일에 여러개의 클리스가 선언될 수 있지만
// public으로 선언하는 클래스는 하나만 허용!!!  & 파일명과 동일해야함
//public class Exam1 {} // error X
//public class Some2 {} // error

// 동일 패키지(디렉토리)내에 동일 이름의 클래스가 중복 선언 될 수 없음
public class Exam1 {}
class Some2 {} // error