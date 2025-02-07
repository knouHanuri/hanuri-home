package hanuri.website.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EBoardCategory {
    info("공지사항", 1),
    qna("Q&A", 2),
    free("자유게시판", 3);

    private final String displayName;
    private final int value;

    EBoardCategory(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

    public static String getDisplayName(int value) {
        return Arrays.stream(EBoardCategory.values())
                .filter(category -> category.value == value)
                .map(EBoardCategory::getDisplayName)
                .findFirst()
                .orElse(null);
    }

}