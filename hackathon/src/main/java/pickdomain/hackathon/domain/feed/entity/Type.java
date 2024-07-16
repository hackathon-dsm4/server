package pickdomain.hackathon.domain.feed.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    FINANCE("금융"),
    STOCK("증권"),
    INDUSTRY("산업/재계"),
    VENTURE("중기/벤처"),
    REAL_ESTATE("부동산"),
    GLOBAL("글로벌 경제"),
    LIVING("생활경제"),
    GENERAL("경제 일반");

    private String type;
}