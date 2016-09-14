import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.com.cookfy.model.User;

public class TestConnection {
	public static void main(String[] a) {
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		User user = new User("andrei", "andrei.andrad", "andrei@g.com");
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		System.out.println("foi rapa");
	}
}
