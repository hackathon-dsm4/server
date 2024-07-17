package pickdomain.hackathon.domain.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickdomain.hackathon.domain.dictionary.entity.Word;

public interface WordRepository extends JpaRepository<Word, Long> {
}
