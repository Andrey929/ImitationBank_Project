package Sourse.Bank;

import Sourse.User;

import java.util.HashMap;

public abstract class Bank {
    static HashMap<String, User>users = new HashMap<>();
    HashMap<String, BankTransaction> transactionHashMap = new HashMap<>();
    public static User getUser(String login){
        return users.get(login);
    }


}
