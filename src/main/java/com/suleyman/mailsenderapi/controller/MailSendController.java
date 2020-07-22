package com.suleyman.mailsenderapi.controller;

import com.suleyman.mailsenderapi.entity.MailUser;
import com.suleyman.mailsenderapi.repository.MailUserRepository;
import com.suleyman.mailsenderapi.util.AES;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/mail")
public class MailSendController {
}
