package wap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wap.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
