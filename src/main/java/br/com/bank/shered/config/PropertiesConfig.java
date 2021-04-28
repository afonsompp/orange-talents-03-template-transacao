package br.com.bank.shered.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(encoding = "UTF-8", value = "classpath:messages.properties")
public class PropertiesConfig {

}
