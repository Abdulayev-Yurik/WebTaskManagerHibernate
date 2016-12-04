package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import taskmanager.model.TaskList;
import taskmanager.service.TaskListService;

import java.util.List;

/**
 * Created by yurik on 02.12.16.
 */
@Controller
@RequestMapping("/api/taskList")
public class TaskListRestController {

    @Autowired
    TaskListService taskListService;

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    List<TaskList> getAllTaskLists(ModelMap modelMap){
        return taskListService.getAllListTasks();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    TaskList getTaskListById(@PathVariable("id")Integer id){
        return taskListService.getTaskListById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    String deleteMessage(@PathVariable("id")Integer id){
        taskListService.deleteList(id);
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PATCH)
    String updateList(@RequestParam("listId")String listId,
                    @RequestParam("listName")String listName){
        taskListService.updateTaskList(listId, listName);
        return "";
    }
}
