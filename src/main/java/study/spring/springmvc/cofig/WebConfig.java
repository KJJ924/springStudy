package study.spring.springmvc.cofig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MemberEditInterceptor()).addPathPatterns("/memberEdit");
        registry.addInterceptor(new MemberEditInterceptor()).addPathPatterns("/beautyShopList");
        registry.addInterceptor(new MemberEditInterceptor()).addPathPatterns("/beautyShopDetailPage");

    }
}
