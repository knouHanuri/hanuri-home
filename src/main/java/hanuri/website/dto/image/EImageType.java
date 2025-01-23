package hanuri.website.dto.image;

import lombok.Getter;

@Getter
public enum EImageType {
    member("회원", 1),
    study("스터디", 2),
    board("게시판", 3);

    private final String displayName;
    private final int value;

    EImageType(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

}
