package hanuri.website.service;

import hanuri.website.dao.ImageMapper;
import hanuri.website.dto.image.ImageDTO;
import hanuri.website.dto.image.ImageRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageMapper imageMapper;

    @Autowired
    public ImageService(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public void save(ImageDTO imageDTO) {
        imageMapper.save(imageDTO);
    }

    public List<ImageDTO> findByObjectId(ImageRequestDTO imageRequestDTO) {
        return imageMapper.findByObjectId(imageRequestDTO);
    }

}
