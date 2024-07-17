package pickdomain.hackathon.domain.dictionary.repository;

import org.springframework.data.jpa.domain.Specification;
import pickdomain.hackathon.domain.dictionary.entity.Dictionary;
import pickdomain.hackathon.domain.dictionary.entity.DictionaryType;

public class DictionarySpecification {

    public static Specification<Dictionary> equalType(DictionaryType type) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type));
    }

    public static Specification<Dictionary> likeKeyword(String keyword) {
        String pattern = "%" + keyword + "%";
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("word"), pattern));
    }
}
