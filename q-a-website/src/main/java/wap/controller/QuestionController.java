package wap.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wap.dto.AnswerDTO;
import wap.model.Question;
import wap.model.Tag;
import wap.service.QuestionsService;
import wap.service.TagsService;
import wap.service.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/questions")
public class QuestionController {
    private final QuestionsService questionsService;
    private final TagsService tagsService;
    private final UsersService usersService;
    public QuestionController(QuestionsService questionsService, TagsService tagsService, UsersService usersService) {
        this.questionsService = questionsService;
        this.tagsService = tagsService;
        this.usersService = usersService;
    }

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

    @GetMapping(path = "/all")
    public ModelAndView getAllQuestions(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("questions.html");
        boolean isLogged = isTokenCookiePresent(request);
        model.addObject("questions", questionsService.getAllQuestions());
        model.addObject("isLogged", isLogged);
        return model;
    }

    @GetMapping("/add")
    public ModelAndView getQuestionView(@CookieValue("token") String token) {
        ModelAndView model = new ModelAndView();
        model.setViewName("addQuestion.html");
        model.addObject("question", new Question());
        model.addObject("tags", tagsService.getAllTags());
        model.addObject("user", usersService.getUserByToken(token));
        return model;
    }
    @PostMapping("/add")
    public void addQuestion(@ModelAttribute("question") Question question, HttpServletResponse response, @RequestParam("selectedTags") List<Integer> selectedTags) throws IOException {
            List<Tag> tags = StreamSupport.stream(tagsService.findAllById(selectedTags).spliterator(), false)
                    .collect(Collectors.toList());
            questionsService.setTags(question, tags);
            question.setTimestamp(new Date(System.currentTimeMillis()));
            questionsService.addQuestion(question);
            response.sendRedirect("/questions/all");
    }

    @RequestMapping(value = "/search/tag", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView searchQuestions(@RequestParam("tagId")  int tagId, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("questionsByTags.html");
        Tag tag = tagsService.findTagById(tagId);
        boolean isLogged = isTokenCookiePresent(request);
        model.addObject("questions", questionsService.findQuestionsByTag(tag));
        model.addObject("isLogged", isLogged);
        return model;
    }

    @PostMapping("/search")
    public ModelAndView searchQuestions(@RequestParam("search") String search, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("questionsByTags.html");
        boolean isLogged = isTokenCookiePresent(request);
        model.addObject("questions", questionsService.getQuestionsByContent(search));
        model.addObject("isLogged", isLogged);
        return model;
    }
    @GetMapping("/question")
    public ModelAndView showQuestion(@RequestParam("questionId") int questionId, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if(isTokenCookiePresent(request)){
            boolean isLogged = isTokenCookiePresent(request);
            Cookie[] cookies = request.getCookies();
            String token ="";
                for (Cookie cookie : cookies) {
                    if ("token".equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
            model.setViewName("question.html");
            model.addObject("question", questionsService.findQuestionById(questionId));
            model.addObject("answer", new AnswerDTO());
            model.addObject("answers", questionsService.getAnswersByQuestionId(questionId));
            model.addObject("loggedUser", usersService.getUserByToken(token));
            model.addObject("isLogged", isLogged);
            } else {
            boolean isLogged = isTokenCookiePresent(request);
            model.setViewName("question.html");
            model.addObject("question", questionsService.findQuestionById(questionId));
            model.addObject("answer", new AnswerDTO());
            model.addObject("answers", questionsService.getAnswersByQuestionId(questionId));
            model.addObject("isLogged", isLogged);
        }


        return model;
    }
}
