package com.example.challenge4_binar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seats")
@Data
public class Seats {
    @Id
    @Setter
    @Getter
    private String studio_name;
    @Setter
    @Getter
    private int nomor_kursi;
}
