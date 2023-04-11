package com.example.challenge4_binar.controller;

import com.example.challenge4_binar.model.Schedules;
import com.example.challenge4_binar.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/schedules")
public class SchedulesController {
    @Autowired
    SchedulesService sc;

    @GetMapping(value = "/{film_code}")
    public List<Schedules> getAll(@PathVariable(value = "film_code") int film_code){
        return sc.getAllSchedules(film_code);
    }

    @PostMapping(value = "/schedule-add/{film_code}")
    public List<Schedules> addSchedule(@PathVariable(value = "film_code") int film_code, @RequestBody List<Schedules> schedules){
        return sc.addScheduleByFilmCode(film_code, schedules);

    }

    @PutMapping(value = "/schedule-update/{film_code}")
    public List<Schedules> updateScheduleByFilmCode(@PathVariable(value = "film_code") int film_code, @RequestBody List<Schedules> schedules){
        return sc.updateScheduleByFilmCode(film_code, schedules);
    }
}
