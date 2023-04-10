package com.example.challenge4_binar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "schedules")
@Data
public class Schedules {
    @Id
    @Setter
    @Getter
    private int schedule_id;

    @ManyToOne
    @JoinColumn(name = "film_code", referencedColumnName = "film_code")
    @JsonBackReference
    private Films film;

    @Setter
    @Getter
    private Date tanggal_tayang;

    @Setter
    @Getter
    private String jam_mulai;

    @Setter
    @Getter
    private String jam_selesai;

    @Setter
    @Getter
    private String harga_tiket;

}
