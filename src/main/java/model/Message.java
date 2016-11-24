package model;

import javax.persistence.*;

/**
 * Created by employee on 11/16/16.
 */
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "taskId")
    private Integer taskId;

    @Column(name = "message_body")
    private String messageBody;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "taskId", updatable = false, insertable = false)
    private Task task;

    public Message(Integer taskId, String messageBody) {
        this.taskId = taskId;
        this.messageBody = messageBody;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
