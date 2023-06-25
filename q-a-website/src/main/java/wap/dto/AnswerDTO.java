package wap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wap.model.Question;
import wap.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private Integer a_id;
    private String content;
    private Integer upvotes;
    private Integer downvotes;
    private Integer q_id;
    private Integer u_id;

}
