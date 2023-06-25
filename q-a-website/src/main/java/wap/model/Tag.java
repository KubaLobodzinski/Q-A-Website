package wap.model;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tags")
public class Tag {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="name")
    private String name;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.PERSIST)
    private List<Question> questions;

    public Tag() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
