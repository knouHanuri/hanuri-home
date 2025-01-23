package hanuri.website.dao;

import hanuri.website.dto.image.ImageDTO;
import hanuri.website.dto.image.ImageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ImageMapper {
    void save(ImageDTO imageDTO);

    List<ImageDTO> findByObjectId(ImageRequestDTO imageRequestDTO);
}
