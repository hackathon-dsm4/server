package pickdomain.hackathon.domain.dictionary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WordType {
    //경제 사회 과학 경영 공공 금융
    경제("ECONOMY"),
    사회("SOCIAL"),
    과학("SCIENCE"),
    경영("MANAGEMENT"),
    공공("PUBLIC"),
    금융("FINANCE"),
    기타("ETC");

    private final String type;
}