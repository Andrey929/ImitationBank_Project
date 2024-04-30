package Data;

import Sourse.Bank.BankTransaction;
import Sourse.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DbConnection {
    static Properties properties = new Properties();
    static {
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/bankdata");
        properties.put(Environment.USER, "Test");
        properties.put(Environment.PASS, "2999");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
    }
    public static SessionFactory sessionFactory;
    public DbConnection() {
        try {
            sessionFactory = new Configuration().setProperties(properties).addAnnotatedClass(User.class).
            addAnnotatedClass(BankTransaction.class).buildSessionFactory();
        }catch (Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }

    }
}
