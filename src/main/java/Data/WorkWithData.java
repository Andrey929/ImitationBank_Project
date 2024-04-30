package Data;

import Sourse.Bank.BankTransaction;
import Sourse.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.query.Query;

public class WorkWithData {
    private static SessionFactory sessionFactory = DbConnection.sessionFactory;

    public static boolean saveUser(User user){
        try (Session session = sessionFactory.openSession()){
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
            return true;
        }catch (Exception e){
            System.out.println("Error");
            return false;
        }
    }
    public static boolean updateUser(User user){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            System.out.println("дошло");
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static User findUser(String login){
        try {
            Session session = sessionFactory.openSession();
            String hql = "from User where login = :login";
            Query<User> query =session.createQuery(hql,User.class);
            query.setParameter("login",login);
            User resUser = query.getSingleResult();
            session.close();
            return resUser;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User", User.class);
            return query.list();
        }
    }

    public static boolean saveTransact(BankTransaction transact){
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(transact);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //public static boolean getTransact(User user){
    //}

}
