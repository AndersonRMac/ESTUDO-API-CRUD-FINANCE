package com.minhasDespesas.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")            //Permitir solicitações do frontEnd React
                .allowedMethods("GET", "PUT", "POST", "DELETE")     //Métodos permitidos
                .allowCredentials(true)                             // Permitir credenciais (por exemplo, cookies)
                .allowedHeaders("*");                               //Permitir todos os cabeçalhos
    }

}
