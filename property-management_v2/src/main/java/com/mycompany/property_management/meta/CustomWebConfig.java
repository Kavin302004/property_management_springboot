package com.mycompany.property_management.meta;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolverSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.WeakHashMap;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

        PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver=new PageableHandlerMethodArgumentResolver();
        pageableHandlerMethodArgumentResolver.setPageParameterName("pageno");
        pageableHandlerMethodArgumentResolver.setSizeParameterName("pagesize");
        //we can even change the starting of page as 1
        //also change the pagenumber parameter in PaginationMeta
        pageableHandlerMethodArgumentResolver.setOneIndexedParameters(true);

        //seen the overrided class for clarity and set this as default
        //this is now set as default for the whole application
        Pageable pageable=PageRequest.of(0, 5);
        pageableHandlerMethodArgumentResolver.setFallbackPageable(pageable);
        resolvers.add(pageableHandlerMethodArgumentResolver);
    }



}
