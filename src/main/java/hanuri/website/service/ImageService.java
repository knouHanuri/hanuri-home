package hanuri.website.service;

import hanuri.website.dao.ImageMapper;
import hanuri.website.dto.image.EImageType;
import hanuri.website.dto.image.ImageDTO;
import hanuri.website.model.ImageSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Slf4j
@Service
public class ImageService {

    @Value("${file.dir}")
    private String fileDir;
    private EImageType ImageType;

    private final ImageMapper imageMapper;

    @Autowired
    public ImageService(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public List<ImageDTO> storeImages(MultipartFile[] multipartFiles, ImageSource imageSource) throws IOException {
        List<ImageDTO> imageDTOList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            imageDTOList.add(store(multipartFile, imageSource));
        }
        return imageDTOList;
    }

    public ImageDTO store(MultipartFile multipartFile, ImageSource imageSource) throws IOException {

        if (multipartFile.isEmpty()) {
            return null;
        }
        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = createStoreFilename(originalFilename);

        Path folderPath = Paths.get(fileDir + imageSource.getImageType());
        //이미지 태그 SRC URL
        String src = "\\" + imageSource.getImageType() + "\\" + storeFilename;

        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        Path fullPath = folderPath.resolve(storeFilename);
        multipartFile.transferTo(new File(fullPath.toString()));

        ImageDTO imageDTO = new ImageDTO(imageSource.getImageType(), imageSource.getObjectId(), folderPath.toString(), originalFilename, storeFilename, src);
        imageMapper.save(imageDTO);
        return imageDTO;
    }

    public List<ImageDTO> findByObjectId(ImageSource imageSource) {
        return imageMapper.findByObjectId(imageSource);
    }

    private String createStoreFilename(String originalFilename) {
        String ext = getExtension(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String getExtension(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    public List<ImageDTO> modifyImages(MultipartFile[] files, ImageSource imageSource) throws IOException {
        //삭제
        if (!files[0].isEmpty()) {
            int count = delete(imageSource);
            log.info("삭제된 파일 수 : " + count);
        }
        //저장
        List<ImageDTO> imageDTOList = new ArrayList<>();
        for (MultipartFile multipartFile : files) {
            imageDTOList.add(store(multipartFile, imageSource));
        }

        return imageDTOList;
    }

    public ImageDTO modify(MultipartFile file, ImageSource imageSource) throws IOException {
        //삭제
        if (!file.isEmpty()) {
            delete(imageSource);
        }
        //저장
        List<ImageDTO> imageDTOList = new ArrayList<>();

        ImageDTO imageDTO;
        imageDTO = store(file, imageSource);
        return imageDTO;
    }

    private int delete(ImageSource imageSource) throws IOException {
        List<ImageDTO> imageList = imageMapper.findByObjectId(imageSource);
        for (ImageDTO imageDTO : imageList) {
            Path storedPath = Paths.get(imageDTO.getFilePath(), imageDTO.getStoreFileName());
            if (Files.exists(storedPath)) {
                Files.delete(storedPath);
                log.info("파일삭제 : " + storedPath);
            }
        }
        return imageMapper.deleteByObjectId(imageSource);
    }


}
