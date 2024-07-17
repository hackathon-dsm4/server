package pickdomain.hackathon.domain.dictionary.dto.responseDto;

import lombok.*;
import pickdomain.hackathon.domain.dictionary.entity.DictionaryType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DictionaryResponseDto {
    private Long wordId;
    private String word;
    private String meaning;
    private DictionaryType type;
}