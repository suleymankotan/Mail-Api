package com.suleyman.mailsenderapi.service;

import com.suleyman.mailsenderapi.config.JavaMailsSender;
import com.suleyman.mailsenderapi.entity.MailSend;
import com.suleyman.mailsenderapi.entity.MailUser;
import com.suleyman.mailsenderapi.repository.MailSendRepository;
import com.suleyman.mailsenderapi.repository.MailUserRepository;
import com.suleyman.mailsenderapi.util.AES;
import com.suleyman.mailsenderapi.util.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailSendService {
    private final MailSendRepository mailSendRepository;
    private final MailUserRepository mailUserRepository;
    private final JavaMailsSender emailSender;

    @Value("${secret.key}")
    private  String key;




    public void mailSendScheduler(){
        List<MailSend> mailSends =mailSendRepository.findAllByStatus(1L);
        if (!mailSends.isEmpty()){
            for (MailSend send:mailSends){
                MailUser mailUser = mailUserRepository.getByKey(send.getMailKey());
                try {
                    emailSender.sendSimpleMessage(Mail.builder().content(send.getText())
                                    .from(mailUser.getEmail())
                                    .subject(send.getSubject())
                                    .to(send.getToFrom()).build()
                            ,AES.decrypt(mailUser.getPassword(),key));
                    send.setStatus(2L);
                    send.setUpdateDate(LocalDateTime.now(ZoneId.of("Europe/Istanbul")));

                    mailSendRepository.save(send);

                }catch (Exception exception){
                    log.error(exception.toString());
                }
            }
        }
    }

}
