package com.zxb.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring Web MVC 配置类，注解驱动
 * @author Mr.zxb
 * @date 2019-08-20 09:31
 */
@Configuration  // 注解配置，Spring范式注解
// @EnableWebMvc   // 组件激活，Spring模块装配    //该注解在SpringFramework WebMVC自动装配时和SpringBoot WebMVC自动装配有差异
// 因为 WebMvcAutoConfiguration类的互斥条件影响，当@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
// 没有配置WebMVC时才会自动化配置
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置视图解析器，硬编码方式，通过application.properties配置优化该方式
     * @return
     */
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("WebMvcConfig preHandle 拦截器拦截中.");
                return true;
            }
        });
    }
}
