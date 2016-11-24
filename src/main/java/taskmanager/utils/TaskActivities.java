package taskmanager.utils;

import taskmanager.model.Task;

import java.util.List;

/**
 * Created by employee on 11/23/16.
 */
public class TaskActivities {

    private List<Task> activeTasks;
    private List<Task> doneTasks;

    public List<Task> getActiveTasks() {
        return activeTasks;
    }

    public void setActiveTasks(List<Task> activeTasks) {
        this.activeTasks = activeTasks;
    }

    public List<Task> getDoneTasks() {
        return doneTasks;
    }

    public void setDoneTasks(List<Task> doneTasks) {
        this.doneTasks = doneTasks;
    }
}
