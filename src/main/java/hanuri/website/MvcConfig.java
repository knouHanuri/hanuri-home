package hanuri.website;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.dir}")
    private String fileDir;

    @Value("${file.upload.path}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 가상 경로 "/uploads/**"를 실제 폴더 경로 "D:/hanuri/"로 매핑
        registry.addResourceHandler(filePath + "/**")
                .addResourceLocations("file:" + fileDir);
    }

}
