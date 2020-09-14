package com.suleyman.mailsenderapi.config;

import com.suleyman.mailsenderapi.model.Mail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.context.annotation.Configuration;
import javax.mail.MessagingException;

@Configuration
@Slf4j
public class JavaMailsSender {

    public void sendSimpleMessage(Mail mail, String mailPassword) throws MessagingException, EmailException {
        HtmlEmail htmlEmail =new HtmlEmail();
        htmlEmail.setHostName("smtp.suleymankotan.com");
        htmlEmail.setSmtpPort(587);
        htmlEmail.setAuthenticator(new DefaultAuthenticator(mail.getFrom(),mailPassword));
        htmlEmail.setFrom(mail.getFrom(),"From");
        htmlEmail.addTo(mail.getTo(),"To");
        htmlEmail.setSubject(mail.getSubject());
        htmlEmail.setHtmlMsg(mail.getContent());

        htmlEmail.send();
        log.info("Mail gönderildi. To: "+mail.getTo());
    }
}
