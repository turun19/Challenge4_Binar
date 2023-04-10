package com.example.challenge4_binar.repository;

import com.example.challenge4_binar.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {
}
