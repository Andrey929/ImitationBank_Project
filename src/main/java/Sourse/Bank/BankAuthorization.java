package Sourse.Bank;

import Data.DbConnection;
import Data.WorkWithData;
import Sourse.*;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BankAuthorization extends Bank{
    public boolean registrationUser(String log,String password){
        User user = new User(log,password);
        if (!users.containsKey(user.getLogin())) {
            if (log != null) {
                users.put(user.getLogin(), user);
                WorkWithData.saveUser(user);
                System.out.println("Успешно !!!");
                return true;
            }else return false;

        }else {
            System.out.println("Данный логин уже существует.(");
            return false;
        }
    }



    public boolean enterUser(String log,String password) {
        User user = WorkWithData.findUser(log);
        if (user != null) {
            System.out.println(user.getPassword());
            if (user.getPassword().equals(password)) {
                System.out.println("Успешно !!!");
                return true;
            } else {
                System.out.println("Пороль неверен");
                return false;
            }
            }else {
            System.out.println("Данный логин не найден");
            return false;
        }
    }
}
