package com.suleyman.mailsenderapi.config;

import com.suleyman.mailsenderapi.util.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@Slf4j
public class JavaMailsSender {

    public void sendSimpleMessage(Mail mail, String mailPassword){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.suleymankotan.com");
        mailSender.setPort(587);
        mailSender.setUsername(mail.getFrom());
        mailSender.setPassword(mailPassword);

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mail.getFrom());
        mailMessage.setTo(mail.getTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getContent());

        // Send mail
        mailSender.send(mailMessage);
        log.info("Mail gönderildi. To: "+mail.getTo());
    }
}
