package Sourse.Bank;

import Sourse.User;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Random;

public class Transaction extends BankOperation {
    private LocalDateTime time;
    private String action;
    private Double summa;
    private String transactionNumber;
    private User user;

    public Transaction(Double summa, String action, User user){
        this.action = action;
        this.summa = summa;
        this.user = user;
        transactionNumber = generateTransactionNumber();
        time = LocalDateTime.now();
    }
    public Transaction(){}
    public void getInfoTransaction(){
        System.out.println(action +" : "+summa);
    }
    private String generateTransactionNumber(){
        byte[] array = new byte[16];
        String str;
        do {
            new Random().nextBytes(array);
            str = new String(array, StandardCharsets.UTF_16);
        }while (transactionHashMap.containsKey(str));
        transactionHashMap.put(str,this);
        return str;
    }

}
