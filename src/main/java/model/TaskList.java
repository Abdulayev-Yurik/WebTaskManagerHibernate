package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurik on 16.11.16.
 */
@Entity
@Table(name = "list_tasks")
public class TaskList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String listName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listTasks")
    private List<Task> tasks = new ArrayList();

    public TaskList(int id, String listName) {
        this.id = id;
        this.listName = listName;
    }

    public TaskList(String listName) {
        this.listName = listName;
    }

    public TaskList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
