package hanuri.website.model;

import hanuri.website.dto.image.EImageType;

public interface ImageSource {
    int getObjectId();

    EImageType getImageType();
}
