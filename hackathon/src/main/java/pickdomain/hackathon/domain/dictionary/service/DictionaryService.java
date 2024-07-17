package pickdomain.hackathon.domain.dictionary.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pickdomain.hackathon.domain.dictionary.dto.responseDto.DictionaryResponseDto;
import pickdomain.hackathon.domain.dictionary.entity.Dictionary;
import pickdomain.hackathon.domain.dictionary.entity.DictionaryType;
import pickdomain.hackathon.domain.dictionary.repository.DictionaryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    public List<DictionaryResponseDto> getwords(DictionaryType type) {
        if(type != null) {
            return dictionaryRepository.findAllByType(type).stream().map(this::CovertDictionaryToDto).collect(Collectors.toList());
        }

        return dictionaryRepository.findAll().stream().map(this::CovertDictionaryToDto).collect(Collectors.toList());
    }

    public DictionaryResponseDto CovertDictionaryToDto(Dictionary dictionary) {
        return DictionaryResponseDto.builder()
                .wordId(dictionary.getWordId())
                .word(dictionary.getWord())
                .meaning(dictionary.getMeaning())
                .type(dictionary.getType()).build();
    }

}
