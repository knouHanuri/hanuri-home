package hanuri.website.domain;

import lombok.Getter;

@Getter
public enum EGender {
    male("남성"),
    female("여성"),
    other("그 외");

    private final String displayName;

    EGender(String displayName)
    {
        this.displayName = displayName;
    }

}
