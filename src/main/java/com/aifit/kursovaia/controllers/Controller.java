package com.aifit.kursovaia.controllers;

import com.aifit.kursovaia.model.Consumer;
import com.aifit.kursovaia.model.Run;
import com.aifit.kursovaia.model.Training;
import com.aifit.kursovaia.model.Weight;
import com.aifit.kursovaia.services.ConsumerService;
import com.aifit.kursovaia.services.RunningService;
import com.aifit.kursovaia.services.TrainingService;
import com.aifit.kursovaia.services.WeightService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private ConsumerService consumerService;
    private WeightService weightService;
    private RunningService runningService;
    private TrainingService trainingService;

    public Controller(ConsumerService consumerService, WeightService weightService, RunningService runningService, TrainingService trainingService){
        this.consumerService = consumerService;
        this.weightService = weightService;
        this.runningService = runningService;
        this.trainingService = trainingService;
    }


    @PostMapping("/registration")
    public boolean addConsumer(@RequestBody Consumer consumer){
        if(consumerService.findByNickname(consumer.getNickname()) != null){
            return false;
        }
        consumerService.addConsumer(consumer);
        return true;
    }

    @PostMapping("/authorize")
    public boolean authorizeConsumer(@RequestBody Consumer consumer){
        if(consumerService.findByNickname(consumer.getNickname()) != null){
            return true;
        }
        return false;
    }

    @PostMapping("/weight/{client_id}")
    public void addWeight(@RequestBody Weight weight, @PathVariable(name = "client_id") int client_id){
        weightService.addWeight(weight, client_id);
    }

    @PostMapping("/run/{client_id}")
    public void addRun(@RequestBody Run run, @PathVariable(name = "client_id") int client_id){
        runningService.addRun(run, client_id);
    }

    @PostMapping("/training/{client_id}")
    public void addTraining(@RequestBody Training training, @PathVariable(name = "client_id") int client_id){
        trainingService.addTraining(training, client_id);
    }
}