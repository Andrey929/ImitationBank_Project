package Front;
import Sourse.*;
import Sourse.Bank.Bank;
import Sourse.Bank.BankAuthorization;
import Sourse.Bank.BankOperation;

import java.util.Scanner;

public class UserActions {
    Scanner scanner = new Scanner(System.in);
    User user;
    public boolean authorizationAction(){
        BankAuthorization bankAuthorization = new BankAuthorization();
        System.out.println("Войти(1) / Зарегистрироваться(2)");
        int tmp = scanner.nextInt();
        if (tmp == 1) {
            System.out.print("Для входа введите логин : ");
            String login = scanner.nextLine();
            login = scanner.nextLine();
            System.out.println();
            System.out.print("Введите пароль : ");
            String password = scanner.nextLine();
            if (bankAuthorization.enterUser(login,password)){
                user = Bank.getUser(login);
                return true;
            }else return false;
        }else if (tmp == 2) {
            System.out.print("Для регистрации придумайте логин : ");
            String login = scanner.nextLine();
            login = scanner.nextLine();
            System.out.println();
            System.out.print("Придумайте пароль : ");
            String password = scanner.nextLine();
            if (bankAuthorization.registrationUser(login,password)) {
                user = Bank.getUser(login);
                return true;
            }else return false;
        }else {
            System.out.println("Неверное действие");
            return false;
        }
    }
    public void basicActions(){
        BankOperation bankOperation = new BankOperation();
        System.out.println("Пополнить(1) / Снять(2) / Кредит(3) / Баланс(4) / История(5)");
        int tmp = scanner.nextInt();
        switch (tmp){
            case 1 -> {
                System.out.println("Для пополнения введите сумму");
                Double summa = scanner.nextDouble();
                bankOperation.deposit(user,summa);
            }
            case 2 -> {
                System.out.println("Для снятия введите сумму");
                Double summa = scanner.nextDouble();
                bankOperation.withdraw(user,summa);
            }
            case 3 -> {
                System.out.println("На какую сумму кредит ?");
                Double summa = scanner.nextDouble();
                bankOperation.takeCredit(user,summa);
            }
            case 4 -> bankOperation.getBalance(user);
            case 5 -> bankOperation.getHistory(user);
            default -> System.out.println("Неверное действие");
        }

    }

}
