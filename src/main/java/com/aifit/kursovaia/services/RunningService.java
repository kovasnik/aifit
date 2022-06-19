package com.aifit.kursovaia.services;

import com.aifit.kursovaia.model.Consumer;
import com.aifit.kursovaia.model.Run;
import com.aifit.kursovaia.repository.ConsumerRepository;
import com.aifit.kursovaia.repository.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunningService {

    private final RunRepository runRepository;
    private final ConsumerRepository consumerRepository;

    @Autowired
    public RunningService(RunRepository runRepository, ConsumerRepository consumerRepository) {
        this.runRepository = runRepository;
        this.consumerRepository = consumerRepository;
    }

    public void addRun(Run run, int id){
        Consumer r = consumerRepository.getOne(id);
        run.setClient(r);
        runRepository.save(run);
    }

}
