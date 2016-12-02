package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import taskmanager.model.Task;
import taskmanager.service.TaskService;

import java.util.List;

/**
 * Created by employee on 12/2/16.
 */
@Controller
@RequestMapping("/api")
public class Base {

    @Autowired
    TaskService taskService;

    @RequestMapping()
    private @ResponseBody List<Task> getTasks(){
        return taskService.getAllTasks().getActiveTasks();
    }

}
