package com.example.challenge4_binar.repository;

import com.example.challenge4_binar.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {
    @Modifying
    @Query(value = "INSERT INTO Schedules (schedule_id, film, tanggal_tayang, jam_mulai, jam_selesai, harga_tiket) " +
            "SELECT :schedule_id, f, :tanggal_tayang, :jam_mulai, :jam_selesai, :harga_tiket " +
            "FROM Films f WHERE f.film_code = :film_code", nativeQuery = true)
    void addScheduleByFilmCode(
            @Param("schedule_id") int schedule_id,
            @Param("film_code") int film_code,
            @Param("tanggal_tayang") Date tanggal_tayang,
            @Param("jam_mulai") String jam_mulai,
            @Param("jam_selesai") String jam_selesai,
            @Param("harga_tiket") String harga_tiket);

}
