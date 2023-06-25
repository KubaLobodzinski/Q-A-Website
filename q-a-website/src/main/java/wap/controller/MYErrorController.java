package wap.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MYErrorController implements ErrorController {

    @RequestMapping(path = "/error")
    public String sayHello() {
        return "124323!";
    }
}
