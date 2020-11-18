package study.spring.springmvc.cofig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> urlList = Arrays.asList("/memberEdit","/beautyShopDetailPage", "/beautyShopOrder", "/createBeautyShop",
                "/createResultPage", "/designer", "/menu", "/BeautyShop");
        registry.addInterceptor(new MemberEditInterceptor()).addPathPatterns(urlList);

        registry.addInterceptor(new CheckLoginSessionInterceptor()).addPathPatterns("/loginForm");
    }
}
