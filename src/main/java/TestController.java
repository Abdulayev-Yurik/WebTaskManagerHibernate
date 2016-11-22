import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by employee on 11/22/16.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/blabla")
    @ResponseBody
    public String index() {
        return "index";
    }
}
