package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import taskmanager.model.Task;
import taskmanager.service.TaskService;

/**
 * Created by yurik on 02.12.16.
 */
@Controller
@RequestMapping("/api/task")
public class TaskRestController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/{taskId}")
    @ResponseBody
    Task getTask(@PathVariable("taskId") Integer id) {
        return taskService.getTaskById(id);
    }

}
