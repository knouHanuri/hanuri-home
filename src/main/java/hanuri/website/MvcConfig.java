package hanuri.website;

import hanuri.website.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/bootstrap/**","/image/**","/js/**","/css/**","/login","/about","/members/new");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 가상 경로 "/images/**"를 실제 폴더 경로 "D:/hanuri/"로 매핑
        registry.addResourceHandler("/hanuri/**")
                .addResourceLocations("file:D:/hanuri/");
    }

}
