package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @ResponseBody
    @RequestMapping("/{taskId}")
    Task getTask(@PathVariable("taskId") Integer id) {
        return taskService.getTaskById(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    String createTask(@RequestParam("title") String title,
                      @RequestParam("details") String details,
                      @RequestParam("listId") Integer listId,
                      @RequestParam("dueDate") String dueDate) {
        taskService.addNewTask(title, details, listId, dueDate);
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/{taskId}", method = RequestMethod.DELETE)
    String deleteTask(@PathVariable("taskId") Integer taskId) {
        taskService.deleteTask(taskId);
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/{taskId}/status/{status}", method = RequestMethod.PUT)
    String switchStatusTask(@PathVariable("taskId") Integer taskId) {
        taskService.switchTaskActivity(taskId);
        return "{status:\"done\"}";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PATCH)
    String updateTask(@RequestParam("id")Integer id,
                    @RequestParam("title")String title,
                    @RequestParam("details")String det,
                    @RequestParam("date")String dueDate){
        taskService.updateTask(id, title, det, dueDate);
        return "{status:\"done\"}";
    }

}
