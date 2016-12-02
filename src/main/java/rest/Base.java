package rest;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import taskmanager.model.Task;
import taskmanager.service.TaskService;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by employee on 12/2/16.
 */
@Controller
@RequestMapping("/api")
public class Base {

    @Autowired
    TaskService taskService;

    @JsonIgnore
    @ManyToOne
    @RequestMapping()
    private @ResponseBody List<Task> getTasks(){
        return taskService.getAllTasks().getActiveTasks();
    }

}
