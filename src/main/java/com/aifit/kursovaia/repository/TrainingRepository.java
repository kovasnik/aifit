package com.aifit.kursovaia.repository;

import com.aifit.kursovaia.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
}
