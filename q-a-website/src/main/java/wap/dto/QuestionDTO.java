package wap.dto;

import lombok.*;
import wap.model.Answer;
import wap.model.User;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class QuestionDTO {
    private Integer q_id;
    private String topic;
    private String content;
    private Integer upvotes;
    private Integer downvotes;
    private User user;
    private List<Answer> answers;
}
