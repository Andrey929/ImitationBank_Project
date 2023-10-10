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
            userActions.basicActions();
            System.out.println("Вы хотите закончить ? Да(1) / Нет(2)");
            int tmp = scanner.nextInt();
            if (tmp == 1) {
                break;
            }
        }
    }
}
