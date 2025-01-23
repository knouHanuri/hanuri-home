package hanuri.website.domain;

public enum EBoardCategory {
    info("공지사항", 1),
    qna("Q&A", 2),
    gallery("갤러리", 3);

    private final String displayName;
    private final int value;

    EBoardCategory(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }
}