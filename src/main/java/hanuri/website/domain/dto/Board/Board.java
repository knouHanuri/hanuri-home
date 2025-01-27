package hanuri.website.domain.dto.Board;

import hanuri.website.dto.image.EImageType;
import hanuri.website.model.ImageSource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board implements ImageSource {
    private int boardId;
    private String title;
    private int memberId;
    private int categoryId;
    private String content;
    private Date createdDate;
    private Date updatedDate;
    private boolean isComplete;
    private boolean isPublic;

    @Override
    public int getObjectId() {
        return boardId;
    }

    @Override
    public EImageType getImageType() {
        return EImageType.board;
    }

}
