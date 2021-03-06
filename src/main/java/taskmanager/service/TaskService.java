package taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.dao.TaskDAO;
import taskmanager.model.Task;
import taskmanager.utils.TaskActivities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/23/16.
 */
@Service
public class TaskService {

    @Autowired
    TaskDAO taskDAO;


    public TaskActivities getAllTasks() {
        TaskActivities activities = new TaskActivities();
        List<Task> taskActiveList = new ArrayList();
        List<Task> taskDoneList = new ArrayList();

        List<Task> tasks = taskDAO.getAllTasks();
        for (Task task : tasks) {
            if (task.getStatus()) {
                taskActiveList.add(task);
            } else {
                taskDoneList.add(task);
            }
        }
        activities.setActiveTasks(taskActiveList);
        activities.setDoneTasks(taskDoneList);

        return activities;
    }

    public TaskActivities getAllTasks(String listId) {
        TaskActivities activities = new TaskActivities();

        List<Task> taskActiveList = new ArrayList();
        List<Task> taskDoneList = new ArrayList();

        List<Task> tasks = taskDAO.getTasksFromList(listId);
        for (Task task : tasks) {
            if (task.getStatus()) {
                taskActiveList.add(task);
            } else {
                taskDoneList.add(task);
            }
        }
        activities.setActiveTasks(taskActiveList);
        activities.setDoneTasks(taskDoneList);

        return activities;
    }

    public void addNewTask(String title, String details, int listId, String dueDate){
        taskDAO.addNewTask(title, details, listId, dueDate);
    }

    public void deleteTask(int taskId) {
        taskDAO.deleteTask(taskId);
    }

    public void switchTaskActivity(int taskId) {
        taskDAO.switchStatusTask(taskId);
    }

    public Task getTaskById(int taskId) {
        return taskDAO.getTaskById(taskId);
    }

    public void updateTask(int id, String title, String det, String dueDate) {
        taskDAO.updateTask(id, title, det, dueDate);
    }
}
