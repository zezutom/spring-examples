package org.zezutom.springseries0114.part05.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.zezutom.springseries0114.part05.service.JsonPrinter;
import org.zezutom.springseries0114.part05.service.PrinterService;
import org.zezutom.springseries0114.part05.service.XmlPrinter;

@Configuration
@ComponentScan(basePackageClasses = PrinterService.class)
public class AppConfig {

    @Bean
    public PrinterService<JsonPrinter> jsonService() {
        return new PrinterService<JsonPrinter>(new JsonPrinter());
    }

    @Bean
    public PrinterService<XmlPrinter> xmlService() {
        return new PrinterService<XmlPrinter>(new XmlPrinter());
    }

}
