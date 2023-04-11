package com.example.challenge4_binar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "schedules")
@Data
public class Schedules {
    @Id
    private int schedule_id;

    @ManyToOne
    @JoinColumn(name = "film_code", referencedColumnName = "film_code")
    @JsonBackReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "film_code", scope = Films.class)
    private Films film;
    private Date tanggal_tayang;
    private String jam_mulai;
    private String jam_selesai;
    private String harga_tiket;

}
