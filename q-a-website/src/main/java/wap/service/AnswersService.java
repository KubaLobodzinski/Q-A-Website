package wap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wap.model.Answer;
import wap.repository.AnswerRepository;

@Service
public class AnswersService {
    @Autowired
    private AnswerRepository answerRepository;

    public void addAnswer(Answer answer) {
       answerRepository.save(answer);
    }
}
