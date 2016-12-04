package taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.dao.TaskListDAO;
import taskmanager.model.TaskList;

import java.util.List;

/**
 * Created by employee on 11/23/16.
 */
@Service
public class TaskListService {

    @Autowired
    TaskListDAO taskListDAO;


    public List<TaskList> getAllListTasks() {
        return taskListDAO.getAllListTasks();
    }

    public void createTaskList(String title) {
        taskListDAO.createNewList(title);
    }

    public void deleteList(Integer id) {
        taskListDAO.deleteTaskList(id);
    }

    public void updateTaskList(String listId, String listName) {
        taskListDAO.updateTaskList(listId, listName);
    }

    public TaskList getTaskListById(Integer id) {
        return taskListDAO.getTaskListById(id);
    }
}
