package wap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class Controller {

    @GetMapping(path = "/hello")
    public String sayHello() {
        return "124323!";
    }
}
