package com.example.GymDiaryBackend.repositories;

import com.example.GymDiaryBackend.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {
    List<Exercise> findByUserIdAndDate(Integer userId, String date);
    List<Exercise> findByUserIdAndName(Integer userId, String name);
    List<Exercise> findByUserId(Integer id);
}
