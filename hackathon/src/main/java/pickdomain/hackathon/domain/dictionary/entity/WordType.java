package pickdomain.hackathon.domain.dictionary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WordType {
    //경제 사회 과학 경영 공공 금융
    ECONOMY("경제"),
    SOCIAL("사회"),
    SCIENCE("과학"),
    MANAGEMENT("경영"),
    PUBLIC("공공"),
    FINANCE("금융"),
    ETC("기타");

    private final String type;
}