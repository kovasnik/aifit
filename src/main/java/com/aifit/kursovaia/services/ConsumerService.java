package com.aifit.kursovaia.services;

import com.aifit.kursovaia.model.Consumer;
import com.aifit.kursovaia.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {

    private ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(ConsumerRepository repository){
        this.consumerRepository = repository;
    }

    public List<Consumer> getAll(){
        return consumerRepository.findAll();
    }

    public void addConsumer(Consumer consumer){
        consumerRepository.saveAndFlush(consumer);
    }

    public Consumer findByNickname(String nickname){
        return consumerRepository.findByNickname(nickname);
    }
}
