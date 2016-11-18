package console;

import dao.ListDAO;
import model.ListTasks;
import model.Task;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
public class ConsoleRunner {

    private SessionFactory sessionFactory;
    private ListDAO listDAO;

    public ConsoleRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        run();
    }

    private void run() {
        viewAllTasks();
    }

    private void viewAllTasks() {
        listDAO = new ListDAO(sessionFactory);
        List<ListTasks> list = listDAO.getAllListTasks();
        System.out.println("----All Tasks----");
        for (ListTasks listTask : list) {
            System.out.println(listTask.getId() + ") " + listTask.getListName());
            for (Task task : listTask.getTasks()) {
                System.out.println("    " + task.getTaskTitle());
            }
        }
        System.out.println("-----------------");
    }
}
