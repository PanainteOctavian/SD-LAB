package org.example.config

import org.example.interceptors.GeoFilterInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class WebConfig(
    private val geoFilterInterceptor: GeoFilterInterceptor
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry
            .addInterceptor(geoFilterInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns("/actuator/**", "/health", "/error")
    }
}