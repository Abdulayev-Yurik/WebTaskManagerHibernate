package taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.dao.MessageDAO;

/**
 * Created by employee on 11/24/16.
 */
@Service
public class MessageService {

    @Autowired
    MessageDAO messageDAO;

    public void deleteMessage(String mId) {
        messageDAO.deleteMessage(mId);
    }

    public void createMessage(String taskId, String messageText){
        messageDAO.addNewMessage(taskId, messageText);
    }
}
