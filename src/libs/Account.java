package libs;

import java.text.NumberFormat;

public class Account {
    // 利息 3.5%
    private final double RATE = 0.035;

    private long acctNumber;
    private double balance;
    private String name;

//    初始化
    public Account(String owner, long account, double initial) {
        name = owner;
        acctNumber = account;
        balance = initial;
    }

//    存款
    public double deposit(double amount) {
        balance = balance + amount;
        return balance;
    }

//    扣费用
    public double withdraw(double amount, double fee) {
        balance = balance - amount - fee;
        return balance;
    }

//    加利息
    public double addInterest() {
        balance += (balance * RATE);
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
//        return "Account{" +
//                "RATE=" + RATE +
//                ", acctNumber=" + acctNumber +
//                ", balance=" + balance +
//                ", name='" + name + '\'' +
//                '}';
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return acctNumber + "\t" + name + "\t" + fmt.format(balance);
    }
}