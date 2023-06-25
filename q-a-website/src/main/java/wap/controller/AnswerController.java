package wap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import wap.model.Answer;
import wap.service.AnswersService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswersService answersService;

    public AnswerController(AnswersService answersService) {
        this.answersService = answersService;
    }

    @PostMapping("/add")
    public ModelAndView addAnswer(@ModelAttribute("answer") Answer answer, BindingResult result, HttpServletResponse response) throws IOException {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("question.html");
            return modelAndView;
        } else {
            answer.setUpvotes(0);
            answer.setDownvotes(0);
            answersService.addAnswer(answer);
            response.sendRedirect("/questions/question/?questionId=" + answer.getQ_id());
            return null;
        }
    }
}