package com.example.challenge4_binar.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "films")
@Data
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer film_code;
    private String film_name;
    private String sedang_tayang_atau_tidak;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Schedules> schedules;
}
