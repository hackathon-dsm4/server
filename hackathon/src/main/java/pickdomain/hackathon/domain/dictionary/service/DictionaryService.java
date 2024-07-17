package pickdomain.hackathon.domain.dictionary.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.dictionary.dto.responseDto.DictionaryResponseDto;
import pickdomain.hackathon.domain.dictionary.entity.Dictionary;
import pickdomain.hackathon.domain.dictionary.repository.DictionaryRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    public Page<DictionaryResponseDto> getwords(int page, Specification<Dictionary> spec) {
        return dictionaryRepository.findAll(spec, PageRequest.of(page,7)).map(this::CovertDictionaryToDto);
    }

    public DictionaryResponseDto CovertDictionaryToDto(Dictionary dictionary) {
        return DictionaryResponseDto.builder()
                .wordId(dictionary.getWordId())
                .word(dictionary.getWord())
                .meaning(dictionary.getMeaning())
                .type(dictionary.getType()).build();
    }

}
