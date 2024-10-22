package com.seisoul.compamyManagementSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将外部文件目录映射为 URL 路径
        registry.addResourceHandler("/files/**") // 访问 URL 以 /files/ 开头
                .addResourceLocations("file:/Users/wangzheng/Desktop/請求書一覧/"); // 这里填写你外部文件目录的实际路径
    }
}
