package taskmanager.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/15/16.
 */
@Entity
@Table(name = "task_table")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listId", insertable = false, updatable = false )
    private TaskList listTasks;

    @Column(name = "title")
    private String taskTitle;

    @Column(name = "details")
    private String details;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "listId")
    private Integer listId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task")
    @Cascade({CascadeType.DELETE})
    private List<Message> messages = new ArrayList();

    public Task(int taskId, String taskTitle) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        isActive = true;
    }

    public Task(int taskId, String taskTitle, String details, boolean isActive) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.details = details;
        this.isActive = isActive;
    }

    public Task(int taskId, String taskTitle, String details, boolean isActive, int listId) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.details = details;
        this.isActive = isActive;
        this.listId = listId;
    }

    public Task(String taskTitle, String details, boolean isActive, int listId) {
        this.taskTitle = taskTitle;
        this.details = details;
        this.isActive = isActive;
        this.listId = listId;
    }

    public Task() {
    }

    public Task(String title, String details, int listId, String dueDate, boolean isActive) {
        this.taskTitle = title;
        this.details = details;
        this.listId = listId;
        this.dueDate = dueDate;
        this.isActive = isActive;
    }

//    @Column(name = "title")
    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Integer getMessagesValues() {
        return messages.size();
    }

//    @Column(name = "id")
    public int getTaskId() {
        return taskId;
    }

//    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

//    @Column(name = "isActive")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TaskList getListTasks() {
        return listTasks;
    }

    public void setListTasks(TaskList listTasks) {
        this.listTasks = listTasks;
    }
}
