import Sourse.Bank.BankAuthorization;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankAuthorizationTest {
    BankAuthorization bankAuthorization = new BankAuthorization();

    @ParameterizedTest
    @CsvSource({"Andreyka,2222",
            "stp,65"})
    public void registrationUser(String login, String password) {
        assertTrue(bankAuthorization.registrationUser(login, password));
    }
    {bankAuthorization.registrationUser("Andrey","2222");}
    @ParameterizedTest
    @CsvSource({"Andrey,2222",
            "Andrey,2222"})
    public void enterUser(String login, String password) {
        assertTrue(bankAuthorization.enterUser(login, password));
    }
}
