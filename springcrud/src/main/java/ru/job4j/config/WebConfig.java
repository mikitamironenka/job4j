package ru.job4j.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //сообщает Spring что данный класс является конфигурационным
// и содержит определения и зависимости bean-компонентов
@EnableWebMvc //позволяет импортировать конфигурацию Spring MVC из класса WebMvcConfigurationSupport
@ComponentScan(basePackages = "ru.job4j")  // сообщает Spring где искать компоненты, которыми он должен управлять,
// т.е. классы, помеченные аннотацией @Component или ее производными,
// такими как @Controller, @Repository, @Service. Эти аннотации автоматически определяют бин класса.
public class WebConfig {

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
