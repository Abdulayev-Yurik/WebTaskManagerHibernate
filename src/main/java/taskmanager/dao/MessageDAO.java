package taskmanager.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import taskmanager.model.Message;
import taskmanager.model.Task;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by employee on 11/17/16.
 */
@Repository
@Transactional
public class MessageDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addNewMessage(int taskId, String messageText) {
        Session currentSession = sessionFactory.getCurrentSession();
        Message message = new Message(taskId, messageText);
        currentSession.save(message);
        Task task = (Task) currentSession.createCriteria(Task.class)
                .add(eq("id", taskId))
                .uniqueResult();
        task.getMessages().add(message);
        currentSession.save(task);
    }

    public void deleteMessage(int id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Message.class).add(eq("id", id));
        Message message = (Message) criteria.uniqueResult();
        session.delete(message);
    }

    public void updateMessage(int id, String messageBody) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Message.class)
                .add(eq("id", id));
        Message message = (Message) criteria.uniqueResult();
        message.setMessageBody(messageBody);
        session.save(message);
    }
}
