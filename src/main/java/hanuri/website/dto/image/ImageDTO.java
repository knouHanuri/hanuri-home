package hanuri.website.dto.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDTO {
    private Long imageId;
    private EImageType ImageType;
    private Long objectId;
    private String filePath;
    private String originalFileName;
    private String storeFileName;
    private String src;

    public ImageDTO() {

    }

    public ImageDTO(EImageType imageType, Long objectId) {
        this.ImageType = imageType;
        this.objectId = objectId;
    }

    public ImageDTO(EImageType imageType, Long objectId, String filePath, String originalFileName, String storeFileName, String src) {
        this.ImageType = imageType;
        this.objectId = objectId;
        this.filePath = filePath;
        this.originalFileName = originalFileName;
        this.storeFileName = storeFileName;
        this.src = src;
    }


}
