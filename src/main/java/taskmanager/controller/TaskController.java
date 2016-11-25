package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import taskmanager.model.TaskList;
import taskmanager.service.MessageService;
import taskmanager.service.TaskListService;
import taskmanager.service.TaskService;

import java.util.List;

/**
 * Created by employee on 11/24/16.
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskListService taskListService;

    @Autowired
    TaskService taskService;

    @Autowired
    MessageService messageService;

    @RequestMapping("")
    String createTask(ModelMap modelMap) {
        List<TaskList> taskLists = taskListService.getAllListTasks();
        modelMap.addAttribute("lists", taskLists);
        return "add_task";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    String createTask(@RequestParam("title") String title,
                      @RequestParam("details") String details,
                      @RequestParam("listId") Integer listId,
                      @RequestParam("dueDate") String dueDate) {
        taskService.addNewTask(title, details, listId, dueDate);
        return "redirect:/home";
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    String deleteTask(@RequestParam("taskId") String taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/home";
    }

    @RequestMapping(value = "/switch", method = RequestMethod.PUT)
    String switchTask(@RequestParam("taskId") String taskId,
                      @RequestParam("active") Boolean status) {
        taskService.switchTaskActivity(taskId, status);
        return "redirect:/home";
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    void updateTask(@RequestParam("id")String id,
                    @RequestParam("title")String title,
                    @RequestParam("details")String det,
                    @RequestParam("date")String dueDate){
        taskService.updateTask(id, title, det, dueDate);
    }


}
