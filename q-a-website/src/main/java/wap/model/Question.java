package wap.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="questions")
public class Question {

    @Id
    @Column(name ="q_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer q_id;

    @Column(name ="topic")
    private String topic;

    @Column(name ="content")
    private String content;

    @Column(name ="upvotes")
    private Integer upvotes;

    @Column(name ="downvotes")
    private Integer downvotes;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_tag",
                joinColumns =  @JoinColumn(name = "q_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public Question(){

    }
    public Integer getQ_id() {
        return q_id;
    }

    public void setQ_id(Integer q_id) {
        this.q_id = q_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public Integer getU_id() {
        return user.getU_id();
    }

    public void setU_id(Integer u_id) {
        this.user = user;
    }

    public Question(Integer q_id, String topic, String content, Integer upvotes, Integer downvotes, Integer u_id){

    }
}
