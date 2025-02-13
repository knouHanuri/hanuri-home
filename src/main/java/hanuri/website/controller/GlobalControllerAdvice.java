package hanuri.website.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Value("${file.upload.dir}")
    private String fileDir;

    @Value("${file.upload.path}")
    private String filePath;

    @ModelAttribute("fileDir")
    public String getFileDir(){
        return fileDir;
    }

    @ModelAttribute("filePath")
    public String getFilePath(){
        return filePath;
    }
}
