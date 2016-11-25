package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import taskmanager.service.MessageService;

/**
 * Created by employee on 11/24/16.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    String deleteMessage(@RequestParam("messageId")String mId, @RequestParam("taskId")String taskId){
        messageService.deleteMessage(mId);
        return "redirect:/details?taskId=" + taskId;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    String createMessage(@RequestParam("taskId")String taskId, @RequestParam("mBody")String messageBody){
        messageService.createMessage(taskId, messageBody);
        return "redirect:/details?taskId=" + taskId;
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    void updateMessage(@RequestParam("id")String id,
                       @RequestParam("msg")String message){
        messageService.updateMessage(id, message);
    }
}
