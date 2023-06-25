package wap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wap.model.Question;
import wap.model.Tag;
import wap.service.TagsService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/tags")
public class TagController {

    @Autowired
    private TagsService tagsService;
    @GetMapping("/add")
    public ModelAndView addTag() {
        ModelAndView model = new ModelAndView();
        model.setViewName("addTag.html");
        model.addObject("tag", new Tag());
        return model;
    }

    @PostMapping("/add")
    public void addTag(@ModelAttribute("tag") Tag tag, HttpServletResponse response) throws IOException {
        tagsService.addTag(tag);
        response.sendRedirect("/main");
    }
}
