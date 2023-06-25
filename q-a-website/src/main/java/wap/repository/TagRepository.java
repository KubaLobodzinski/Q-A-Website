package wap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wap.model.Tag;

import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {

    Iterable<Tag> findAllById(Integer t_id);
    Optional<Tag> findById(Integer t_id);
}
