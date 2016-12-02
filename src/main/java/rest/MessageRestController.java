package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import taskmanager.service.MessageService;

/**
 * Created by yurik on 02.12.16.
 */
@Controller
@RequestMapping("/api/message")
public class MessageRestController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    String deleteMessage(@PathVariable()Integer id) {
        messageService.deleteMessage(id);
        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    String createMessage(@RequestParam("taskId")Integer taskId, @RequestParam("mBody")String messageBody){
        messageService.createMessage(taskId, messageBody);
        return "";
    }

    @RequestMapping(method = RequestMethod.PATCH)
    @ResponseBody
    String updateMessage(@RequestParam("id") Integer id,
                         @RequestParam("msg")String message){
        messageService.updateMessage(id, message);
        return "";
    }
}
