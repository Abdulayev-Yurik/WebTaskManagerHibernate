package console;

import dao.TaskListDAO;
import model.TaskList;
import model.Task;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
public class ConsoleRunner {

    private SessionFactory sessionFactory;
    private TaskListDAO taskListDAO;

    public ConsoleRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        run();
    }

    private void run() {
        viewAllTasks();
    }

    private void viewAllTasks() {
        taskListDAO = new TaskListDAO(sessionFactory);
        List<TaskList> list = taskListDAO.getAllListTasks();
        System.out.println("----All Tasks----");
        for (TaskList listTask : list) {
            System.out.println(listTask.getId() + ") " + listTask.getListName());
            for (Task task : listTask.getTasks()) {
                System.out.println("    " + task.getTaskTitle());
            }
        }
        System.out.println("-----------------");
    }
}
