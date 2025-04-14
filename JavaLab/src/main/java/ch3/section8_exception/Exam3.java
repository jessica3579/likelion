package ch3.section8_exception;

// 사용자 정의 예외
// 은행 시스템을 가정
// 예금 인출, 입금이 진행된다...
// 입금이 0보다 작은 수가 들어옴 or 출금이 잔고보다 큰 수가 들어옴..
// 이런 상황은 java 적으로는 예외 상황은 아님
// 이런 상황을 true, false 등으로 적절하게 처리할 수도 있기는 하지만..
// 이 상황을 앱에서 존재할 수 없는 상황으로 보고 custom exception으로 처리해서
// 예외처리 코드에 의해 코드가 개발되게 하고 싶다.

class BadBankingException extends Exception {
    // 복잡하게 작성할 수도 있지만..
    // 어떤 에러인지를 클래스명(type)으로 구분할 용도이지
    // 에러 발생에 대응하는 곳은 다른 곳에서..
    // 거의 대부분 아래처럼.. 작성함
    BadBankingException(String s) { //예외 던질 때 항상 메시지를 포함하면 지금처럼 String 매개변수만 있는 생성자만 작성해도 됨(기본 생성자 없는)
        super(s);
    }
}

// 통장을 추상화 시킨 클래스...
class BankAccount {
    private String name;
    private int number; // 통장 번호
    private int balance; // 통장 잔고

    BankAccount(String name, int number, int balance) {
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    // 출금 요청..
    void withdraw(int amt) throws BadBankingException {
        if (amt > balance) {
            throw new BadBankingException("잔액 부족");
        }
        balance -= amt;
    }

    // 입금
    void deposit(int amt) throws BadBankingException {
        if (amt < 0) {
            throw new BadBankingException("0보다 작은 금액 입금 요청");
        }
        balance += amt;
    }

}

public class Exam3 {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("이수지", 1, 1000);
        try {
            myAccount.withdraw(3000);
        } catch (BadBankingException e) {
            System.out.println(e);
        }
        try {
            myAccount.deposit(-20);
        } catch (BadBankingException e) {
            System.out.println(e);
        }

    }
}
