package hanuri.website.dao;

import hanuri.website.dto.image.ImageDTO;
import hanuri.website.model.ImageSource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ImageMapper {
    void save(ImageDTO imageDTO);
    List<ImageDTO> findByObjectId(ImageSource imageSource);
    int deleteByObjectId(ImageSource imageSource);
}
