package com.aifit.kursovaia.services;

import com.aifit.kursovaia.model.Consumer;
import com.aifit.kursovaia.model.Training;
import com.aifit.kursovaia.repository.ConsumerRepository;

import com.aifit.kursovaia.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final ConsumerRepository consumerRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository, ConsumerRepository consumerRepository) {
        this.trainingRepository = trainingRepository;
        this.consumerRepository = consumerRepository;
    }

    public void addTraining(Training training, int id){
        Consumer t = consumerRepository.getOne(id);
        training.setClient(t);
        trainingRepository.save(training);
    }
}
