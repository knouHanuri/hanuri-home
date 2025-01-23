package hanuri.website.dto.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDTO {
    private int imageId;
    private EImageType ImageType;
    private int objectId;
    private String filePath;
    private String fileName;
    private String extension;
    private String newFileName;
    private String src;

}
