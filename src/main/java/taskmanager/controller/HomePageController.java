package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import taskmanager.service.TaskListService;
import taskmanager.service.TaskService;
import taskmanager.utils.TaskActivities;

/**
 * Created by employee on 11/23/16.
 */
@Controller
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskListService taskListService;

    @RequestMapping("")
    String homePage(ModelMap modelMap){
        TaskActivities activities = taskService.getAllTasks();

        modelMap.addAttribute("taskActiveList", activities.getActiveTasks());
        modelMap.addAttribute("taskDoneList", activities.getDoneTasks());
        modelMap.addAttribute("taskLists", taskListService.getAllListTasks());
        return "home";
    }

    @RequestMapping("/{listId}")
    String homePage(ModelMap modelMap,
                    @PathVariable String listId){
        System.out.println();
        TaskActivities activities = taskService.getAllTasks(listId);

        modelMap.addAttribute("listId", listId);
        modelMap.addAttribute("taskActiveList", activities.getActiveTasks());
        modelMap.addAttribute("taskDoneList", activities.getDoneTasks());
        modelMap.addAttribute("taskLists", taskListService.getAllListTasks());
        return "home";
    }

}
