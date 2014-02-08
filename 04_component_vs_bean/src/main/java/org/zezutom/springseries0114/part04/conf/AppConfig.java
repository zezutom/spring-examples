package org.zezutom.springseries0114.part04.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.zezutom.springseries0114.part04.model.MessageBuilder;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.zezutom.springseries0114.part04.web")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MessageBuilder messageBuilder() {
        return new MessageBuilder();
    }
}
