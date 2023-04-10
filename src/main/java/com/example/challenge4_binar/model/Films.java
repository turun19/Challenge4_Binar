package com.example.challenge4_binar.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
@Data
public class Films {
    @Id
    @Setter
    @Getter
    private int film_code;
    @Setter
    @Getter
    private String film_name;
    @Setter
    @Getter
    private String sedang_tayang_atau_tidak;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Schedules> schedules;
}
