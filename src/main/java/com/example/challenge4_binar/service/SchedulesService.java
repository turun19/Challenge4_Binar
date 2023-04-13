package com.example.challenge4_binar.service;

import com.example.challenge4_binar.model.Films;
import com.example.challenge4_binar.model.Schedules;
import com.example.challenge4_binar.repository.FilmsRepository;
import com.example.challenge4_binar.repository.SchedulesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulesService {
    @Autowired
    SchedulesRepository scR;
    @Autowired
    FilmsRepository fsr;

    public SchedulesService(FilmsRepository filmRepository, SchedulesRepository scheduleRepository) {
        this.fsr = filmRepository;
        this.scR = scheduleRepository;
    }

    public List<Schedules> getAllSchedules(int film_code) {
        return fsr.findById(film_code).get().getSchedules();
    }

    public List<Schedules> addScheduleByFilmCode(int film_code, List<Schedules> schedules) {
        Optional<Films> films = fsr.findById(film_code);

        if (films.isPresent()) {
            for (Schedules schedule : schedules) {
                schedule.setFilm(films.get());
                scR.save(schedule);
            }
            return schedules;
        } else {
            throw new IllegalArgumentException("Film Code Tidak Ada");
        }
    }

    public List<Schedules> updateScheduleByFilmCode(int film_code, List<Schedules> schedules) {
        List<Schedules> scheduleUpdate = new ArrayList<>();
        Optional<Films> films = fsr.findById(film_code);
        if (films.isPresent()) {
            for (Schedules scheduleFromRequest : schedules) {
                Optional<Schedules> schedulesFromDatabaseOpt = scR.findById(scheduleFromRequest.getSchedule_id());
                if (schedulesFromDatabaseOpt.isPresent()) {
                    Schedules schedulesFromDatabase = schedulesFromDatabaseOpt.get();
                    schedulesFromDatabase.setFilm(films.get());
                    schedulesFromDatabase.setJam_mulai(scheduleFromRequest.getJam_mulai());
                    schedulesFromDatabase.setHarga_tiket(scheduleFromRequest.getHarga_tiket());
                    schedulesFromDatabase.setJam_selesai(scheduleFromRequest.getJam_selesai());
                    schedulesFromDatabase.setTanggal_tayang(scheduleFromRequest.getTanggal_tayang());
                    scheduleUpdate.add(scR.save(schedulesFromDatabase));
                } else {
                    throw new IllegalArgumentException("Schedule ID Tidak Ada");
                }
            }
            return scheduleUpdate;
        } else {
            throw new IllegalArgumentException("Film Code Tidak Ada");
        }
    }
}
