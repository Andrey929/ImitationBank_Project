import Sourse.Bank.BankOperation;
import Sourse.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankOperationTest {

    BankOperation bankOperation = new BankOperation();
    @Test
    public void deposit(){
        User user = new User("check1","1234");
        bankOperation.deposit(user,1000d);
        assertEquals(1000,user.getMoney());

    }
    @Test
    public void withdraw() {
        User user = new User("check2","1234");
        bankOperation.deposit(user,1000d);
        bankOperation.withdraw(user,400d);
        assertEquals(600,user.getMoney());
    }
}
