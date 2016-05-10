package flowctrl.sample.common.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by allbegray on 2016-05-10.
 */
@Component
public class MessageSourceContextHolder {

    private static MessageSource messageSource;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    protected void setup() {
        this.messageSource = applicationContext.getBean(MessageSource.class);
    }

    private MessageSourceContextHolder() {
    }

    public static MessageSource getMessageSource() {
        return messageSource;
    }

}
