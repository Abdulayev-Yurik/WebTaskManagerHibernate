package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import taskmanager.service.TaskService;

/**
 * Created by employee on 11/24/16.
 */
@Controller
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String viewDetails(@RequestParam("taskId")Integer taskId, ModelMap modelMap){
        modelMap.addAttribute("task", taskService.getTaskById(taskId));
        return "details";
    }
}
