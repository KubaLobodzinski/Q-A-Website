package wap.model;

import javax.persistence.*;


@Entity
@Table(name="questions")
public class Question {

    @Id
    @Column(name ="q_id")
    private Integer q_id;

    @Column(name ="topic")
    private String topic;

    @Column(name ="content")
    private String content;

    @Column(name ="upvotes")
    private Integer upvotes;

    @Column(name ="downvotes")
    private Integer downvotes;

    @Id
    @Column(name ="u_id")
    private Integer u_id;

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
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Question(Integer q_id, String topic, String content, Integer upvotes, Integer downvotes,Integer u_id){

    }
}
