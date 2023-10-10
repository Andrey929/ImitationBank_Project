package Sourse.Bank;

import Sourse.User;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Bank {
    HashMap<String, User>users = new HashMap<>();
    HashMap<String,Transaction> transactionHashMap = new HashMap<>();

}
