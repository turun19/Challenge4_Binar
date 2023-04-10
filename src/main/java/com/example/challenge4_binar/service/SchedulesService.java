package com.example.challenge4_binar.service;

import com.example.challenge4_binar.model.Schedules;
import com.example.challenge4_binar.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchedulesService {
    @Autowired
    SchedulesRepository scR;

    public Optional<Schedules> getAllSchedules(int schedule_id) {
        return scR.findById(schedule_id);
    }
}
