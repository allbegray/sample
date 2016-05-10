package flowctrl.sample.common.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import flowctrl.sample.Constants;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

/**
 * Created by allbegray on 2016-04-28.
 */
@Configuration
@ComponentScan(basePackages = Constants.BASE_PACKAGE, excludeFilters = {@ComponentScan.Filter({Configuration.class, Controller.class})})
@Import(value = {PersistenceConfig.class})
public class RootConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper;
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
