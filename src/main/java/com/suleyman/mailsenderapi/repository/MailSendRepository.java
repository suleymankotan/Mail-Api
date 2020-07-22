package com.suleyman.mailsenderapi.repository;

import com.suleyman.mailsenderapi.entity.MailSend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailSendRepository extends JpaRepository<MailSend,Long> {
    List<MailSend> findAllByStatus(Long status);

}
