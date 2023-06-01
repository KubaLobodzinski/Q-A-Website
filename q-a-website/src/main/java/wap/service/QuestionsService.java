package wap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wap.dto.QuestionDTO;
import wap.model.Question;
import wap.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionsService{

    @Autowired
    private QuestionRepository questionRepository;

    public void addQuestion(Question question){
        Question question1 = new Question();
        question1.setTopic(question.getTopic());
        question1.setContent(question.getContent());
        question1.setUpvotes(0);
        question1.setDownvotes(0);
        question1.setU_id(1);
        questionRepository.save(question1);
    }

    public Iterable<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

}
