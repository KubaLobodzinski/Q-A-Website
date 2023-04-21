package wap.model;
import javax.persistence.*;


@Entity
@Table(name="tags")


public class Tag {
    @Id
    @Column(name ="t_id")
    private Integer t_id;

    @Column(name ="name")
    private String name;

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag(Integer t_id, String name){

    }
}
