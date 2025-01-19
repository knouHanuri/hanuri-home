package hanuri.website.domain;

public enum EMembershipLevel {
    admin("관리자"),
    normal("정회원"),
    guest("준회원");

    private final String displayName;

    EMembershipLevel(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }
}
