package wap.model;

import javax.persistence.*;


@Entity
@Table(name="comments")

public class Comment {

    @Id
    @Column(name ="c_id")
    private Integer c_id;

    @Column(name ="content")
    private String content;

    @Id
    @Column(name ="u_id")
    private Integer u_id;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Comment(Integer c_id, String content, Integer u_id){

    }
}
