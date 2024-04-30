package Sourse;

import Data.WorkWithData;
import Sourse.Bank.BankTransaction;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users",schema = "bankdata")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "money")
    private Double money;
    @Column(name = "credit_debt")
    private Double creditDebt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankTransaction> transactions = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        money = 0d;
        creditDebt = 0d;
    }

    public User() {
    }

    public int getUserId(){
        return id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
        WorkWithData.updateUser(this);
        System.out.println("gdfjvbbj");
    }

    public Double getCreditDebt() {
        return creditDebt;
    }

    public void setCreditDebt(Double credit) {
        this.creditDebt = credit;
        this.money += credit;
        WorkWithData.updateUser(this);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        WorkWithData.updateUser(this);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        WorkWithData.updateUser(this);
    }

    public void addTransaction(BankTransaction transaction){
        if (WorkWithData.saveTransact(transaction)) {

        }else {
            System.out.println("Транзакция не была окончена по причине Error");
        }
    }
    public List<BankTransaction> getHistoryTransactions(){
        return transactions;
    }
}
