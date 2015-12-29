package com.grinyov.springinaction.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Конфигурация для определения бинов DispatcherServlet
 *
 * Аннотация @EnableWebMvc включает Spring MVC
 * Аннотация @ComponentScan указывает путь где искать контроллеры(они буду иметь аннотацию @Controller)
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.grinyov.springinaction.spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    // настройка бина view resolver, он настроен для поиска файлов JSP
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
    // включая данную настройку DispatcherServlet будет спрашивать про обработку
    // запросов для статических ресурсов, а не обрабатывать их сам
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}