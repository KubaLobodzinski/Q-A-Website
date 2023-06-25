package wap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import wap.dto.QuestionDTO;
import wap.model.Answer;
import wap.model.Question;
import wap.model.Tag;
import wap.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService{

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TagsService tagsService;

    public void addQuestion(Question question) {
        question.setUpvotes(0);
        question.setDownvotes(0);
        questionRepository.save(question);
    }

    public Iterable<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public Iterable<Question> getAllQuestionsByDate(){
        return questionRepository.findAllSortedByTimestamp();
    }

    public Iterable<Question> getQuestionsByContent(String content){
        return questionRepository.findByContent(content);
    }

    public void setTags(Question question, Iterable<Tag> tags) {
        List<Tag> tagList = new ArrayList<>();
        tags.forEach(tagList::add);
        question.setTags(tagList);
    }

    public Object findQuestionsByTag(Tag tag) {
        return questionRepository.findByTags(tag);
    }

    public Optional<Question> findQuestionById(Integer q_id) {
        return questionRepository.findById(q_id);
    }

    public Iterable<Answer> getAnswersByQuestionId(Integer q_id) {
        Optional<Question> question = questionRepository.findById(q_id);
        if (question.isPresent()) {
            return question.get().getAnswers();
        }
        return null;
    }
}
