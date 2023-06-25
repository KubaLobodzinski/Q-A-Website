package wap.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wap.model.Question;
import wap.model.Tag;

import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q FROM Question q ORDER BY q.timestamp DESC")
    Iterable<Question> findAllSortedByTimestamp();

    @Query("SELECT q FROM Question q WHERE q.content LIKE %?1% OR q.topic LIKE %?1% ORDER BY q.timestamp DESC")
    Iterable<Question> findByContent(String content);

    Iterable<Question> findByTags(Tag tag);

    Optional<Question> findById(Integer q_id);

}
