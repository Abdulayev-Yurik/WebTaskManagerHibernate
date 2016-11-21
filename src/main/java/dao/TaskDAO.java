package dao;

import model.Message;
import model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by employee on 11/16/16.
 */
public class TaskDAO {

    private Session session;

    public TaskDAO(SessionFactory factory) {
        this.session = factory.openSession();
    }

    public List<Task> getAllTasks(){
        Criteria criteria = session.createCriteria(Task.class);
        List<Task> list = (List<Task>) criteria.list();
        session.close();
        return list;
    }

    public List<Task> getTasksFromList(String listId) {
        if (listId.equals("0"))
            return getAllTasks();
        Criteria criteria = session.createCriteria(Task.class)
                .add(eq("listId", parseInt(listId)));
        List<Task> taskList = (List<Task>) criteria.list();
        session.close();
        return taskList;
    }


    public void addNewTask(String title, String details, int listId, String dueDate) {
        session.beginTransaction();
        Task task = new Task(title, details, listId, dueDate, true);
        session.save(task);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteTask(String taskId) {
        session.beginTransaction();
        Task task = (Task) session.createCriteria(Task.class)
                .add(eq("id", taskId)).uniqueResult();
        session.delete(task);
        session.getTransaction().commit();
        session.close();
    }

    public void switchStatusTask(String taskId, boolean isActive) {
        session.beginTransaction();
        Task task = (Task) session.createCriteria(Task.class)
                .add(eq("id", taskId)).uniqueResult();
        task.setActive(isActive);
        session.update(task);
        session.getTransaction().commit();
        session.close();
    }

    public Task getTaskById(String taskId) {
        Task task = (Task) session.createCriteria(Task.class)
                .add(eq("id", taskId))
                .uniqueResult();
        return task;
    }

    private List<Message> getTaskMessages(String taskId) {
        Task task = (Task) session.createCriteria(Task.class)
                .add(eq("id", taskId))
                .uniqueResult();
        return task.getMessages();
    }

    public void addNewMessage(String taskId, String messageText) {
        session.beginTransaction();
        Message message = new Message(parseInt(taskId), messageText);
        session.save(message);
        Task task = (Task) session.createCriteria(Task.class)
                .add(eq("id", taskId))
                .uniqueResult();
        task.getMessages().add(message);
        session.save(task);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteMessage(String messageId) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Message.class).add(eq("id", messageId));
        Message message = (Message) criteria.uniqueResult();
        session.delete(message);
        session.getTransaction().commit();
        session.close();
    }

}
