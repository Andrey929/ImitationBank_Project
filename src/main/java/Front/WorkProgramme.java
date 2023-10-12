package Front;

import java.util.Scanner;

public class WorkProgramme extends UserActions{
    public static void startProgramme(){
        UserActions userActions = new UserActions();
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (!userActions.authorizationAction()){
                break;
            }
            int tmp;
            do {
                System.out.println("Продолжить действие ? Да(1) / Нет(2)");
                tmp = scanner.nextInt();
                userActions.basicActions();
            }while (tmp != 2);

            System.out.println("Вы хотите закончить ? Да(1) / Нет(2)");
            int tmpB = scanner.nextInt();
            if (tmpB == 1) {
                break;
            }
        }
    }
}
