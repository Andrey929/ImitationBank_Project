package Sourse;

import Sourse.Bank.Transaction;

import java.util.ArrayList;

public class User {
    private String login;
    private String password;

    private Double money;
    private Double creditDebt;


    private ArrayList<Transaction> transactions = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        money = 0d;
        creditDebt = 0d;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getCreditDebt() {
        return creditDebt;
    }

    public void setCreditDebt(Double credit) {
        this.creditDebt = credit;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    public ArrayList<Transaction> getHistoryTransactions(){
        return transactions;
    }
}
