package hanuri.website.domain;

import lombok.Getter;

@Getter
public enum EEnrollmentStatus {
    enrolled("재학"),
    suspended("휴학"),
    graduated("졸업");

    private final String displayName;

    EEnrollmentStatus(String displayName)
    {
        this.displayName = displayName;
    }

}
