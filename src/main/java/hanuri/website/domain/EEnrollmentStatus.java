package hanuri.website.domain;

public enum EEnrollmentStatus {
    enrolled("재학"),
    suspended("휴학"),
    graduated("졸업");

    private final String displayName;

    EEnrollmentStatus(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }

}
