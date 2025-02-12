package hanuri.website.model;

import hanuri.website.dto.image.EImageType;

public interface ImageSource {
    Long getObjectId();

    EImageType getImageType();
}
