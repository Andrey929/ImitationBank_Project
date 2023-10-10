package Sourse.Bank;

import Sourse.*;

public class BankAuthorization extends Bank{
    public boolean registrationUser(String log,String password){
        User user = new User(log,password);
        if (!users.containsKey(user.getLogin())) {
            users.put(user.getLogin(), user);
            System.out.println("Успешно !!!");
            return true;
        }else {
            System.out.println("Данный логин уже существует.(");
            return false;
        }
    }
    public boolean enterUser(String log,String password){

        if (users.containsKey(log)) {
            if (password.equals(users.get(log).getPassword())) {
                System.out.println("Успешно !!!");
                return true;
            }else {
                System.out.println("Пороль неверен");
                return false;
            }

        }else {
            System.out.println("Данный логин не найден");
            return false;
        }
    }
}
