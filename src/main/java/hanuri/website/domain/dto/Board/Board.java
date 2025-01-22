package hanuri.website.domain.dto.Board;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board {
    private int boardId;
    private String title;
    private int memberId;
    private int categoryId;
    private String content;
    private Date createdDate;
    private Date updatedDate;
    private boolean isComplete;
    private boolean isPublic;
    private int imageId;
}
