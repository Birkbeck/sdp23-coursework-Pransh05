package sml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


@Configuration
@ComponentScan({"sml.instructionfactory"})
public class AppConfig {
    @Bean
    Function<String, RegisterName> registerValue() {
        return Registers.Register :: valueOf;
    }
}

