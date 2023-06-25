package wap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wap.model.User;
import wap.service.QuestionsService;
import wap.service.TagsService;
import wap.service.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    private final TagsService tagsService = new TagsService();

    @Autowired
    private final QuestionsService questionsService = new QuestionsService();

    @Autowired
    private final UsersService usersService = new UsersService();


    private boolean isTokenCookiePresent(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @GetMapping("/main")
    public ModelAndView getMainPage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("main.html");
        model.addObject("tags", tagsService.getAllTags());
        model.addObject("questions", questionsService.getAllQuestionsByDate());
        boolean isLogged = isTokenCookiePresent(request);
        model.addObject("isLogged", isLogged);
        return model;
    }
}
