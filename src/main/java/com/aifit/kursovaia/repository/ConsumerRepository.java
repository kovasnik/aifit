package com.aifit.kursovaia.repository;

import com.aifit.kursovaia.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
    Consumer findByNickname(String login);
}
