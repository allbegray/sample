package allbegray.sample.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * Created by allbegray on 2016-08-31.
 */
@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfig {

    protected static final String PROPERTY_NAME_MAIL_HOST = "mail.host";
    protected static final String PROPERTY_NAME_MAIL_PORT = "mail.port";
    protected static final String PROPERTY_NAME_MAIL_USERNAME = "mail.username";
    protected static final String PROPERTY_NAME_MAIL_PASSWORD = "mail.password";
    protected static final String PROPERTY_NAME_MAIL_ENCODING = "mail.encoding";

    @Autowired
    private Environment environment;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(environment.getProperty(PROPERTY_NAME_MAIL_HOST));

        String port = environment.getProperty(PROPERTY_NAME_MAIL_PORT);
        if (StringUtils.hasText(port)) {
            sender.setPort(Integer.parseInt(port));
        }

        sender.setUsername(environment.getProperty(PROPERTY_NAME_MAIL_USERNAME));
        sender.setPassword(environment.getProperty(PROPERTY_NAME_MAIL_PASSWORD));
        sender.setDefaultEncoding(environment.getProperty(PROPERTY_NAME_MAIL_ENCODING));

        Properties props = new Properties();
        props.put("mail.transport.protocol", "stmp");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", false);

        sender.setJavaMailProperties(props);
        return sender;
    }

}
