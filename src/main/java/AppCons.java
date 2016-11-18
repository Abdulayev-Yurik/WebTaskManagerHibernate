import console.ConsoleRunner;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import model.ListTasks;
import model.Task;
import util.HibernateUtil;

import java.util.List;

public class AppCons {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (Annotation)");
		SessionFactory session = HibernateUtil.getSessionFactory();

        new ConsoleRunner(session);
        System.out.println("Done");
	}
}
