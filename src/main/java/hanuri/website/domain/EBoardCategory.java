package hanuri.website.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static DisplayNameValuePair getDisplayNameAndValue(int value) {
        return Arrays.stream(EBoardCategory.values())
                .filter(category -> category.value == value)
                .map(category -> new DisplayNameValuePair(category.getDisplayName(), category.getValue()))
                .findFirst()
                .orElse(null);

    }

    @Getter
    public static class DisplayNameValuePair{
        private final String displayName;
        private final int value;
        public DisplayNameValuePair(String displayName, int value) {
            this.displayName = displayName;
            this.value = value;
        }
    }

}