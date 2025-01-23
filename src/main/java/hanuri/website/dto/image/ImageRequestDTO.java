package hanuri.website.dto.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageRequestDTO {
    private EImageType imageType;
    private int objectId;

    public ImageRequestDTO(EImageType imageType, int objectId) {
        this.imageType = imageType;
        this.objectId = objectId;
    }
}
