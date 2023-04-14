package com.example.challenge4_binar.controller;

import com.example.challenge4_binar.model.Schedules;
import com.example.challenge4_binar.service.SchedulesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping(value = "/schedules")
public class SchedulesController {
    private final Logger logger = Logger.getLogger(SchedulesController.class.getName());
    @Autowired
    SchedulesService sc;

    @GetMapping(value = "/{film_code}")
    public List<Schedules> getAll(@PathVariable(value = "film_code") int film_code){
        logger.info("Sukses menampilkan jadwal berdasarkan film code");
        return sc.getAllSchedules(film_code);
    }

    @PostMapping(value = "/schedule-add/{film_code}")
    public List<Schedules> addSchedule(@PathVariable(value = "film_code") int film_code, @RequestBody List<Schedules> schedules){
        logger.info("Sukses menambahkan schedule berdasarkan film code");
        return sc.addScheduleByFilmCode(film_code, schedules);

    }

    @PutMapping(value = "/schedule-update/{film_code}")
    public List<Schedules> updateScheduleByFilmCode(@PathVariable(value = "film_code") int film_code, @RequestBody List<Schedules> schedules){
        logger.info("Sukses mengupdate schedule berdasarkan film code");
        return sc.updateScheduleByFilmCode(film_code, schedules);
    }
}
