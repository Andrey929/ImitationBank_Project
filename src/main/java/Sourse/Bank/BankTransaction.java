package Sourse.Bank;

import Data.DbConnection;
import Sourse.User;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Random;
@Entity
@Table(name = "transactions",schema = "bankdata")
public class BankTransaction extends BankOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    @Column(name = "transaction_number")
    private String transactionNumber;
    @Column(name = "DataTime")
    private LocalDateTime time;
    @Column(name = "action")
    private String action;
    @Column(name = "sum")
    private Double summa;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public BankTransaction(Double summa, String action, User user){
        this.action = action;
        this.summa = summa;
        this.user = user;
        //userID = user.getUserId();
        transactionNumber = generateTransactionNumber();
        time = LocalDateTime.now();

    }
    public BankTransaction(){}
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
