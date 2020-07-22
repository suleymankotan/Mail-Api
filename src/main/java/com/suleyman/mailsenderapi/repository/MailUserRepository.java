package com.suleyman.mailsenderapi.repository;

import com.suleyman.mailsenderapi.entity.MailUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailUserRepository extends JpaRepository<MailUser,Long> {
    MailUser getByKey(String key);
}
