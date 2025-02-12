package hanuri.website.domain;

import lombok.Getter;

@Getter
public enum EMembershipLevel {
    admin("관리자"),
    normal("정회원"),
    guest("준회원");

    private final String displayName;

    EMembershipLevel(String displayName)
    {
        this.displayName = displayName;
    }

}
