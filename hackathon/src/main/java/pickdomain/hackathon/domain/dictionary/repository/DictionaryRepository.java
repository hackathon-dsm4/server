package pickdomain.hackathon.domain.dictionary.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pickdomain.hackathon.domain.dictionary.entity.Dictionary;
import pickdomain.hackathon.domain.dictionary.entity.DictionaryType;

import java.util.List;
import java.util.Optional;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    List<Dictionary> findAllByType(DictionaryType type);
}