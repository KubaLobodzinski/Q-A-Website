package wap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wap.dto.QuestionDTO;
import wap.model.Question;
import wap.repository.QuestionRepository;
import wap.service.QuestionsService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/questions")
public class QuestionController {
    private final QuestionsService questionsService;
    public QuestionController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping(path = "/all")
        public ModelAndView getAllQuestions() {
        ModelAndView model = new ModelAndView();
        model.setViewName("questions.html");
        model.addObject("questions", questionsService.getAllQuestions());
        return model;
    }

    @GetMapping("/add")
    public static ModelAndView getQuestionView() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("addQuestion.html");
            modelAndView.addObject("question", new Question());
            return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView addQuestion(@ModelAttribute("question") Question question, BindingResult result, HttpServletResponse response) throws IOException {
        if (result.hasErrors()){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("addQuestion.html");
            return modelAndView;
        }
        else{
            questionsService.addQuestion(question);
            response.sendRedirect("/questions/all");
            return null;
        }
    }
}
