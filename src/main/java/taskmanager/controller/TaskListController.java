package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import taskmanager.service.TaskListService;

/**
 * Created by employee on 11/24/16.
 */
@Controller
@RequestMapping("/taskList")
public class TaskListController {

    @Autowired
    TaskListService taskListService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String viewTaskList(ModelMap modelMap){
        modelMap.addAttribute("taskLists", taskListService.getAllListTasks());
        return "task_list";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    String createNewTaskList(@RequestParam("title")String title, ModelMap modelMap){
        taskListService.createTaskList(title);
        modelMap.addAttribute("taskLists", taskListService.getAllListTasks());
        return "task_list";
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    String deleteMessage(@RequestParam("listId")String listId, ModelMap modelMap){
        taskListService.deleteList(listId);
        modelMap.addAttribute("taskLists", taskListService.getAllListTasks());
        return "task_list";
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    void updateList(@RequestParam("listId")String listId,
                    @RequestParam("listName")String listName){
        taskListService.updateTaskList(listId, listName);
    }

}
