package wap.model;

import javax.persistence.*;


@Entity
@Table(name="questionstags")
public class QuestionsTags {
    @Id
    @Column(name ="q_id")
    private Integer q_id;

    @Id
    @Column(name ="t_id")
    private Integer t_id;

    public Integer getQ_id() {
        return q_id;
    }

    public void setQ_id(Integer q_id) {
        this.q_id = q_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public QuestionsTags(Integer q_id, Integer t_id){

    }
}
