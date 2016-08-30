package allbegray.sample.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.Future;

/**
 * Created by allbegray on 2016-08-31.
 */
@Component
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public Future<Boolean> sendMail() throws InterruptedException, MessagingException {
        System.out.println("sending mail..");

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setSubject("재목");
        helper.setText("<h1>내용</h1>", true);
        helper.setFrom("from@test.com");
        helper.setTo("to@test.com");

        javaMailSender.send(message);

        System.out.println("sending mail completed");
        return new AsyncResult<Boolean>(true);
    }

}
