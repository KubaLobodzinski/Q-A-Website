package wap.model;

import javax.persistence.*;


@Entity
@Table(name="answers")
public class Answer {

    @Id
    @Column(name ="a_id")
    private Integer a_id;

    @Column(name ="content")
    private String content;

    @Column(name ="upvotes")
    private Integer upvotes;

    @Column(name ="downvotes")
    private Integer downvotes;

    @Id
    @Column(name ="q_id")
    private Integer q_id;
    @Id
    @Column(name ="u_id")
    private Integer u_id;

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
        return q_id;
    }

    public void setQ_id(Integer q_id) {
        this.q_id = q_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Answer(Integer a_id, String content, Integer upvotes, Integer downvotes, Integer q_id, Integer u_id){

    }
}
