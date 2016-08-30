package allbegray.sample.common.config;

import allbegray.sample.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;

/**
 * Created by allbegray on 2016-04-28.
 */
@Configuration
@EnableAsync
@ComponentScan(basePackages = Constants.BASE_PACKAGE, excludeFilters = {@ComponentScan.Filter({Configuration.class, Controller.class})})
@Import(value = {PersistenceConfig.class, MailConfig.class})
public class RootConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder
                .json()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .failOnUnknownProperties(false)
                .modules(new JavaTimeModule())
                .build();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("i18n.messages", "classpath:org/hibernate/validator/ValidationMessages", "classpath:org/springframework/security/messages");
        messageSource.setDefaultEncoding(Constants.ENCODING);
        messageSource.setUseCodeAsDefaultMessage(false);
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

}
