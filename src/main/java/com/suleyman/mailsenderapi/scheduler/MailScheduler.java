package com.suleyman.mailsenderapi.scheduler;


import com.suleyman.mailsenderapi.service.MailSendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
class MailScheduler {

    private final MailSendService mailSendService;

    @Scheduled(cron = "0 * * * * *")
    public void sendMail(){
        mailSendService.mailSendScheduler();
    }
}
