package taskmanager.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import taskmanager.model.Message;
import taskmanager.model.Task;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by employee on 11/16/16.
 */
@Repository
@Transactional
public class TaskDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<Task> getAllTasks(){
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(Task.class);
        List<Task> list = (List<Task>) criteria.list();
        return list;
    }

    public List<Task> getTasksFromList(String listId) {
        if (listId.equals("0"))
            return getAllTasks();
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(Task.class)
                .add(eq("listId", parseInt(listId)));
        List<Task> taskList = (List<Task>) criteria.list();
        return taskList;
    }


    public void addNewTask(String title, String details, int listId, String dueDate) {
        Task task = new Task(title, details, listId, dueDate, true);
        sessionFactory.getCurrentSession().save(task);
    }

    public void deleteTask(int taskId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Task task = (Task) currentSession.createCriteria(Task.class)
                .add(eq("id", taskId)).uniqueResult();
        currentSession.delete(task);
    }

    public void switchStatusTask(int taskId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Task task = (Task) currentSession.createCriteria(Task.class)
                .add(eq("id", taskId)).uniqueResult();
        task.setActive(!task.isActive());
        currentSession.update(task);
    }

    public Task getTaskById(int taskId) {
        Task task = (Task) sessionFactory.getCurrentSession()
                .createCriteria(Task.class)
                .add(eq("id", taskId))
                .uniqueResult();
        return task;
    }

    private List<Message> getTaskMessages(int taskId) {
        Task task = (Task) sessionFactory.getCurrentSession()
                .createCriteria(Task.class)
                .add(eq("id", taskId))
                .uniqueResult();
        return task.getMessages();
    }

    public void updateTask(int id, String title, String det, String dueDate) {
        Session session = sessionFactory.getCurrentSession();
        Task task = (Task) session.createCriteria(Task.class).add(eq("id", id)).uniqueResult();
        task.setTaskTitle(title);
        task.setDetails(det);
        task.setDueDate(dueDate);
        session.save(task);
    }
}
