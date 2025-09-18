package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("web")
@PropertySource("classpath:database.properties")
@Import({HibernateConfig.class, WebConfig.class})

public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig initialized!"); // Debug сообщение
    }
}