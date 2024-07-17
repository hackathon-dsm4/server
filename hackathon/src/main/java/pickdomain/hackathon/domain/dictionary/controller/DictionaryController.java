package pickdomain.hackathon.domain.dictionary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pickdomain.hackathon.domain.dictionary.dto.responseDto.DictionaryResponseDto;
import pickdomain.hackathon.domain.dictionary.entity.Dictionary;
import pickdomain.hackathon.domain.dictionary.entity.DictionaryType;
import pickdomain.hackathon.domain.dictionary.repository.DictionarySpecification;
import pickdomain.hackathon.domain.dictionary.service.DictionaryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dict")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @GetMapping
    public List<DictionaryResponseDto> getWords (
            @RequestParam(required = false) DictionaryType type
    ) {
        return dictionaryService.getwords(type);
    }

}
