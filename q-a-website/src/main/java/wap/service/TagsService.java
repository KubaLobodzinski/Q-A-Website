package wap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wap.model.Tag;
import wap.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagsService {

    @Autowired
    private TagRepository tagRepository;

    public Iterable<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Iterable<Tag> findAllById(List<Integer> tagIds) {
        List<Tag> tags = new ArrayList<>();
        for (Integer tagId : tagIds) {
            tagRepository.findAllById(tagId).forEach(tags::add);
        }
        return tags;
    }

    public Tag findTagById(int tagId) {
        return tagRepository.findById(tagId).orElse(null);
    }

    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }
}
