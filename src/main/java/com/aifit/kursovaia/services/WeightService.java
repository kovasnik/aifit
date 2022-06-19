package com.aifit.kursovaia.services;

import com.aifit.kursovaia.model.Consumer;
import com.aifit.kursovaia.model.Weight;
import com.aifit.kursovaia.repository.ConsumerRepository;
import com.aifit.kursovaia.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeightService {

    public WeightRepository weightRepository;
    public ConsumerRepository consumerRepository;

    @Autowired
    public WeightService(WeightRepository weightRepository, ConsumerRepository consumerRepository) {
        this.weightRepository = weightRepository;
        this.consumerRepository = consumerRepository;
    }

    public void addWeight(Weight weight, int id){
        Consumer w = consumerRepository.getOne(id);
        weight.setClient(w);
        weightRepository.save(weight);
    }
}
