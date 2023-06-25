package wap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="answers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @Column(name ="a_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer a_id;

    @Column(name ="content")
    private String content;

    @Column(name ="upvotes")
    private Integer upvotes;

    @Column(name ="downvotes")
    private Integer downvotes;

    @ManyToOne
    @JoinColumn(name = "q_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    public Integer getQ_id() {
        return question.getQ_id();
    }

    public void setQ_id(Question question) {
        this.question = question;
    }

    public Integer getU_id() {
        return user.getU_id();
    }

    public void setU_id(User user) {
        this.user = user;
    }

    public Answer(Integer a_id, String content, Integer upvotes, Integer downvotes, Integer q_id, Integer u_id){

    }
}
