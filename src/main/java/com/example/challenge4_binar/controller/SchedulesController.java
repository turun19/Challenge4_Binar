package com.example.challenge4_binar.controller;

import com.example.challenge4_binar.model.Schedules;
import com.example.challenge4_binar.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/schedules")
public class SchedulesController {
    @Autowired
    SchedulesService sc;

    @GetMapping(value = "/{schedule_id}")
    public Optional<Schedules> getAll(@PathVariable int schedule_id){
        return sc.getAllSchedules(schedule_id);
    }
}
