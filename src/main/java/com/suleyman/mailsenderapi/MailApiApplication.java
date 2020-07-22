package com.suleyman.mailsenderapi;

import com.suleyman.mailsenderapi.util.AES;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
public class MailApiApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MailApiApplication.class, args);
	}

}
