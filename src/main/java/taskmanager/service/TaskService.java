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
            if (task.isActive()) {
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
            if (task.isActive()) {
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

    public void deleteTask(String taskId) {
        taskDAO.deleteTask(taskId);
    }

    public void switchTaskActivity(String taskId, boolean status) {
        taskDAO.switchStatusTask(taskId, !status);
    }

    public Task getTaskById(String taskId) {
        return taskDAO.getTaskById(taskId);
    }
}
