package taskmanager.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import taskmanager.model.Message;
import taskmanager.model.Task;
import taskmanager.model.TaskList;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by employee on 11/17/16.
 */
@Repository
@Transactional
public class TaskListDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<TaskList> getAllListTasks() {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(TaskList.class);
        List<TaskList> taskLists = (List<TaskList>) criteria.list();
        for (TaskList taskList : taskLists) {
            for (Task task : taskList.getTasks()) {
                task.getDetails();
            }
        }
        return taskLists;
    }

    public void createNewList(String title) {
        sessionFactory.getCurrentSession().save(new TaskList(title));
    }

    public void deleteTaskList(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TaskList.class)
                .add(eq("id", id));
        TaskList taskLists = (TaskList) criteria.uniqueResult();
        for (Task task : taskLists.getTasks()) {
            session.delete(task);
        }
        session.delete(taskLists);
    }

    public void updateTaskList(String listId, String listName) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(TaskList.class)
                .add(eq("id", parseInt(listId)));
        TaskList taskList = (TaskList) criteria.uniqueResult();
        taskList.setListName(listName);
        session.update(taskList);
    }

    public TaskList getTaskListById(Integer id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TaskList.class)
                .add(eq("id", id));
        TaskList taskList = (TaskList) criteria.uniqueResult();
            for (Task task : taskList.getTasks()) {
                for (Message message : task.getMessages()) {
                    message.getId();
                }
            }
        return taskList;
    }
}
