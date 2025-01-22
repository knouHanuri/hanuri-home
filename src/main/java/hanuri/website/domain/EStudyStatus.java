package hanuri.website.domain;

import lombok.Getter;

@Getter
public enum EStudyStatus {
    active("진행중"),
    completed("완료"),
    pending("대기");

    private final String displayName;

    EStudyStatus(String displayName)
    {
        this.displayName = displayName;
    }

}
