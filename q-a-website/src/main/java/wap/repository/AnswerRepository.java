package wap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wap.model.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
}
