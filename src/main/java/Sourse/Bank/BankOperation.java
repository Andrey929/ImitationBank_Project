package Sourse.Bank;

import Sourse.User;

public class BankOperation extends Bank {
    public static final String ADD = "Add";
    public static final String TAKE_OF = "Take of";
    public static final String CREDIT = "Credit";
    public void deposit(User user,Double summa){
        user.setMoney(user.getMoney() + summa);
        user.addTransaction(new Transaction(summa,ADD,user));
    }
    public boolean withdraw(User user,Double summa){
        if (user.getMoney() - summa >= 0) {
            user.setMoney(user.getMoney() - summa);
            user.addTransaction(new Transaction(summa,TAKE_OF,user));
            return true;
        }else{
            System.out.println("Недостаточно средств");
            return false;
        }
    }
    public void takeCredit(User user,Double summa){
        if (user.getCreditDebt() == 0) {
            user.setCreditDebt(summa);
            user.addTransaction(new Transaction(summa,CREDIT,user));
        }
    }
    public void getBalance(User user){
        System.out.println(user.getMoney());
    }
    public void getHistory(User user){
        for (Transaction tr: user.getHistoryTransactions()) {
            tr.getInfoTransaction();
        }
    }
}
