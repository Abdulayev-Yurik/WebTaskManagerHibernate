package dao;

import model.Task;
import model.TaskList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by employee on 11/17/16.
 */
public class TaskListDAO {

    private Session session;

    public TaskListDAO(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public List<TaskList> getAllListTasks() {
        Criteria criteria = session.createCriteria(TaskList.class);
        List<TaskList> taskLists = (List<TaskList>) criteria.list();
        session.close();
        return taskLists;
    }

    public void createNewList(String title) {
        session.beginTransaction();
        session.save(new TaskList(title));
        session.getTransaction().commit();
        session.close();
    }

    public void deleteTaskList(String listId) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TaskList.class)
                .add(eq("id", parseInt(listId)));
        TaskList taskLists = (TaskList) criteria.uniqueResult();
        for (Task task : taskLists.getTasks()) {
            session.delete(task);
        }
        session.flush();
        session.delete(taskLists);
        session.getTransaction().commit();
        session.close();
    }
}
